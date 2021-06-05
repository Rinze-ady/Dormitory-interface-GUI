package com.lovo.roomProject.updatePwd.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.lovo.netCRM.component.LovoButton;
import com.lovo.netCRM.component.LovoPassWordTxt;
import com.lovo.netCRM.component.LovoTitleLabel;
import com.lovo.roomProject.frame.LoginFrame;
/**
 * 
 * 宿舍管理系统
 * @author 张成峰
 * @version 1.0
 * @see  
 * @description 修改密码面板
 */
public class UpdatePwdPanel  extends JPanel{
	/**旧密码文本框*/
	private LovoPassWordTxt oldPwdTxt = new LovoPassWordTxt("请输入旧密码",200,100,this);
	/**新密码文本框*/
	private LovoPassWordTxt newPwdTxt = new LovoPassWordTxt("请输入新密码",200,160,this);
	/**确认密码文本框*/
	private LovoPassWordTxt rePwdTxt = new LovoPassWordTxt("请确认密码",200,220,this);
	/**登陆用户对象*/
	private Object loginUser;
	public UpdatePwdPanel(Object loginUser,JFrame jf){
		this.loginUser = loginUser;
		this.setLayout(null);
		new LovoTitleLabel("修改密码",this);
		
		LovoButton updateButton = new LovoButton(300,280,"修改","image/update.png",this);
		updateButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(updatePwd(loginUser) == false){
					return;
				}
				jf.dispose();
				new LoginFrame();
			}
		});
	}
	
	//-------------------
	/**
	 * 修改密码
	 * @param loginUser 登陆用户对象
	 * @return 验证是否成功
	 */
	private boolean  updatePwd(Object loginUser){
		//验证原密码是否正确
		//验证两次密码是否一致
		
		JOptionPane.showMessageDialog(null, "密码修改成功");
		return true;
	}
}
