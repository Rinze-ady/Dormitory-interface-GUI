package com.lovo.roomProject.student.frame;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JFrame;

import com.lovo.netCRM.component.LovoButton;
import com.lovo.netCRM.component.LovoComboBox;
import com.lovo.netCRM.component.LovoImageLabel;
import com.lovo.netCRM.component.LovoLabel;
import com.lovo.netCRM.component.LovoTable;
import com.lovo.netCRM.component.LovoTitleLabel;
import com.lovo.netCRM.component.LovoTxt;
/**
 * 
 * 宿舍管理系统
 * @author 张成峰 
 * @version 1.0
 * @see  
 * @description 学生修改对话框
 */
public class StudentUpdateDialog extends JDialog{
	/**学生主面板*/
	private StudentPanel studentPanel;
	/**学生ID*/
	private int studentId;
	/**姓名标签*/
	private LovoLabel nameLabel = new LovoLabel("姓    名",40,90,this);
	/**性别标签*/	
	private LovoLabel sexLabel = new LovoLabel("性    别",40,130,this);
	/**班级标签*/
	private LovoLabel classLabel = new LovoLabel("班级",40,170,this);
	/**原房间标签*/
	private LovoLabel oldRoomLabel = new LovoLabel("原房间",40,210,this);
	/**新房间*/
	private LovoComboBox newRoomComboBox;
	/**头像标签*/
	private LovoImageLabel faceLabel = new LovoImageLabel(330, 120, 100, 100,this);
	
	
	public StudentUpdateDialog(JFrame jf,int studentId,StudentPanel studentPanel){
		super(jf,true);
		this.studentPanel = studentPanel;
		this.studentId = studentId;
		
		this.setLayout(null);
		
		this.init();
		
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) screensize.getWidth() / 2 - 310;
		int y = (int) screensize.getHeight() / 2 - 240;
		this.setBounds(x, y, 620, 480);
		this.setVisible(true);
	}
	/**
	 * 初始化
	 *
	 */
	private void init(){
		LovoTitleLabel titleLabel = new LovoTitleLabel("学生换房",this);
		titleLabel.setLocation(240, titleLabel.getY());
		this.initStudentData(this.studentId);
		this.initComboBox();
		
		LovoButton updateButton = new LovoButton(150,330,"换房","image/update.png",this);
		updateButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				changeRoom(studentId);
				StudentUpdateDialog.this.dispose();
			}});
		
		LovoButton cancelButton = new LovoButton(360,330,"取消","image/cancel.png",this);
		cancelButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				StudentUpdateDialog.this.dispose();
			}});
	}
	
	
	//-------------------------------------------
	
	/**
	 * 初始化新房间下拉框
	 *
	 */
	private void initComboBox(){
		//添加新房间List集合
		this.newRoomComboBox = new LovoComboBox("新房间",new ArrayList(),40,250,this);
		
	}
	
	/**
	 * 初始化数据
	 * @param employeeId　员工ID
	 */
	private void initStudentData(int studentId){
		
	}
	
	/**
	 * 学生换房
	 * @param studentId 学生ID
	 */
	private void changeRoom(int studentId){
		//更新数据，显示修改结果
		this.studentPanel.initData();
		
	}
}
