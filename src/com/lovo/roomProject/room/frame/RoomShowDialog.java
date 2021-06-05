package com.lovo.roomProject.room.frame;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JFrame;

import com.lovo.netCRM.component.LovoButton;
import com.lovo.netCRM.component.LovoLabel;
import com.lovo.netCRM.component.LovoTable;
import com.lovo.netCRM.component.LovoTitleLabel;
/**
 * 
 * 宿舍管理系统
 * @author 张成峰
 * @version 1.0
 * @see  
 * @description 显示房间信息
 */
public class RoomShowDialog extends JDialog{

	/**房间地址标签*/
	private LovoLabel addressLabel = new LovoLabel("房间地址",40,120,this);
	/**可容纳人数标签*/
	private LovoLabel roomNumberLabel = new LovoLabel("可容纳人数",320,120,this);
	/**房间状态标签*/
	private LovoLabel roomStatusLabel = new LovoLabel("房间状态",40,180,this);
	/**已住人数标签*/
	private LovoLabel inNumberLabel = new LovoLabel("已住人数",320,180,this);
	/**房间类型标签*/
	private LovoLabel roomTypeLabel = new LovoLabel("房间类型",40,240,this);
	/**所住学生表格组件*/
	private LovoTable studentTable;
	
	/**房间id*/
	private int roomId;
	public RoomShowDialog(JFrame jf,int roomId){
		super(jf,true);
		this.roomId = roomId;
		
		this.setLayout(null);
		
		this.init();
		
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) screensize.getWidth() / 2 - 310;
		int y = (int) screensize.getHeight() / 2 - 315;
		this.setBounds(x, y, 620, 630);
		this.setVisible(true);
	}
	/**
	 * 初始化
	 *
	 */
	private void init() {
		LovoTitleLabel titleLabel = new LovoTitleLabel("房间信息",this);
		titleLabel.setLocation(240, titleLabel.getY());
		this.initTable();
		this.initData(roomId);
		
		LovoButton okButton = new LovoButton(260,480,"确定","image/ok.png",this);
		okButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				RoomShowDialog.this.dispose();
			}});
	}
	
	
	
	//----------------------
	/**
	 * 初始化表格
	 */
	private void initTable() {
		studentTable = new LovoTable(this,
				new String[]{"学生姓名","所在班级","联系电话"},
				new String[]{},//学生实体属性名数组 new String[]{"name","className"}
				"");//主键属性名 studentId
		studentTable.setSizeAndLocation(40, 300, 540, 150);
	}
	/**
	 * 初始化数据
	 * @param roomId 房间ID
	 */
	private void initData(int roomId) {
		studentTable.updateLovoTable(null);
	}

}
