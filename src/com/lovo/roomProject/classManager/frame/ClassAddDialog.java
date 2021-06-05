package com.lovo.roomProject.classManager.frame;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;

import com.lovo.netCRM.component.LovoButton;
import com.lovo.netCRM.component.LovoDate;
import com.lovo.netCRM.component.LovoTable;
import com.lovo.netCRM.component.LovoTitleLabel;
import com.lovo.netCRM.component.LovoTxt;

/**
 * 
 * 宿舍管理系统
 * @author 张成峰
 * @version 1.0
 * @see  
 * @description 添加班级对话框
 */
public class ClassAddDialog extends JDialog{
	/**班级表格*/
	private LovoTable classTable;
	/**班级名称文本框*/
	private LovoTxt nameTxt = new LovoTxt("班级名称",50,120,this);
	/**带班老师文本框*/
	private LovoTxt teacherTxt = new LovoTxt("带班老师",50,180,this);
	/**开班时间日历框*/
	private LovoDate createTimeTxt = new LovoDate("开班时间",50,260,this);
	/**班级面板*/
	private ClassManagerPanel classManagerPanel;
	
	public ClassAddDialog(JFrame jf,ClassManagerPanel classManagerPanel){
		super(jf,true);
		this.classManagerPanel = classManagerPanel;
		this.setLayout(null);
		
		this.init();
		
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) screensize.getWidth() / 2 - 200;
		int y = (int) screensize.getHeight() / 2 - 240;
		this.setBounds(x, y, 400, 480);
		this.setVisible(true);
	}
	
	/**
	 * 初始化
	 *
	 */
	private void init() {
		LovoTitleLabel titleLabel = new LovoTitleLabel("添加班级",this);
		titleLabel.setLocation(140, titleLabel.getY());
		LovoButton addButton = new LovoButton(40,320,"添加","image/add.png",this);
		addButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				boolean isOk = addClass();
				if(isOk){
					ClassAddDialog.this.dispose();
				}
			}});
		
		LovoButton cancelButton = new LovoButton(220,320,"取消","image/cancel.png",this);
		cancelButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				ClassAddDialog.this.dispose();
			}});
	}
	
	//---------------------
	/**
	 * 添加班级
	 */
	private boolean addClass(){
		
		//验证数据，验证失败，返回false
		
//		更新表格，显示添加结果
		this.classManagerPanel.initData();
		
		return true;
	}
}
