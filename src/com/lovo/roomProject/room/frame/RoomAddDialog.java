package com.lovo.roomProject.room.frame;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;

import com.lovo.netCRM.component.LovoButton;
import com.lovo.netCRM.component.LovoComboBox;
import com.lovo.netCRM.component.LovoDate;
import com.lovo.netCRM.component.LovoTitleLabel;
import com.lovo.netCRM.component.LovoTxt;
/**
 * 
 * 宿舍管理系统
 * @author 张成峰
 * @version 1.0
 * @see  
 * @description 添加房间
 */
public class RoomAddDialog extends JDialog{
	/**房间主面板*/
	private RoomPanel roomPanel;
	/**房间地址文本框*/
	private LovoTxt addressTxt = new LovoTxt("房间地址",40,120,this);
	/**可容纳人数文本框*/
	private LovoTxt roomNumberTxt = new LovoTxt("可容纳人数",40,180,this);	
	/**房间类型下拉框*/
	private LovoComboBox roomTypeComboBox = new LovoComboBox("房间类型",
			new String[]{"男生宿舍","女生宿舍"},40,240,this);

	public RoomAddDialog(JFrame jf,RoomPanel roomPanel){
		super(jf,true);
		this.roomPanel = roomPanel;
		this.setLayout(null);
		this.setTitle("添加房间");
		
		this.init();
		
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) screensize.getWidth() / 2 - 180;
		int y = (int) screensize.getHeight() / 2 - 225;
		this.setBounds(x, y, 360, 450);
		this.setVisible(true);
	}
	/**
	 * 初始化
	 *
	 */
	private void init() {
		LovoTitleLabel titleLabel = new LovoTitleLabel("添加房间",this);
		titleLabel.setLocation(140, titleLabel.getY());
		LovoButton addButton = new LovoButton(60,300,"添加","image/add.png",this);
		addButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				boolean isOk = addRoom();
				if(isOk){
					RoomAddDialog.this.dispose();
				}
			}});
		
		LovoButton cancelButton = new LovoButton(180,300,"取消","image/cancel.png",this);
		cancelButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				RoomAddDialog.this.dispose();
			}});
	}
	
	//----------------------
	/**
	 * 添加房间
	 */
	private boolean addRoom(){
		//验证数据，数据验证失败返回false
		
		
		//更新表格，显示添加房间结果
		roomPanel.initData();
		return true;
	}
}
