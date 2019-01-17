package com.github.binarywang.demo.wx.mp.Service;

import com.github.binarywang.demo.wx.mp.dao.AdminMapper;
import com.github.binarywang.demo.wx.mp.dao.WxMapper;
import com.github.binarywang.demo.wx.mp.model.Json;
import com.github.binarywang.demo.wx.mp.model.bean.Admin;
import com.github.binarywang.demo.wx.mp.model.bean.AdminExample;
import com.github.binarywang.demo.wx.mp.model.bean.WxBean;
import com.github.binarywang.demo.wx.mp.utils.LaserUtils;
import com.github.binarywang.demo.wx.mp.utils.PBKDF2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BondingServiceImpl implements BondingService {

    @Autowired
    private AdminMapper adminDao;

    @Autowired
    private WxMapper wxDao;

    @Override
    public Json bonding(String username, String password, String openId) throws Exception {
        Json json=new Json();

        //判断此微信是否绑定过
        List<WxBean> wxBeanList=wxDao.selectByOpenId(openId);
        if (wxBeanList!=null&&wxBeanList.size()!=0){
            json.setMsg("您的微信已经绑定过账户");
            json.setSuccess(false);
            return json;
        }


        //查询要绑定的同户名是否存在
        AdminExample adminExample=new AdminExample();
        adminExample.createCriteria().andNameEqualTo(username);
        List<Admin> userList=adminDao.selectByExample(adminExample);
        Admin admin = userList == null || userList.size() < 1 ? null : userList.get(0);

        if (admin!=null){
            String random = admin.getPwd().split(":")[0];
            String pwd = PBKDF2.generateStorngPasswordHash256ByBCP(LaserUtils.hexStringToBinarys(random),
                password);
            if (admin.getPwd().equals(pwd)){

                if (admin.getId().equals("0")){
                    json.setMsg("超管账户不支持绑定，请重新输入。");
                    json.setSuccess(false);
                    return json;
                }
                List<WxBean> wxlist=wxDao.selectByadminId(admin.getId());
                if (wxlist!=null&&wxlist.size()!=0){
                    json.setMsg("您的账号已经绑定过");
                    json.setSuccess(false);
                    return json;
                }
                //插入绑定记录
                WxBean wxBean=new WxBean();
                wxBean.setAdminId(admin.getId());
                wxBean.setOpenId(openId);
                int insertcount=wxDao.insertWxBean(wxBean);

                if (insertcount!=1){
                    json.setMsg("绑定失败，请重试");
                    json.setSuccess(false);
                    return json;
                }


                json.setMsg("绑定成功！");
                json.setSuccess(true);



            }else {
                json.setMsg("您输入密码错误，请重新输入。");
                json.setSuccess(false);
                return json;
            }


        }else {
            json.setMsg("您输入的用户名不存在，请重新输入。");
            json.setSuccess(false);
        }
        return json;

    }
}
