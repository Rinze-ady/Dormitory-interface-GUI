package com.lovo.roomProject.room.frame;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JFrame;

import com.lovo.netCRM.component.LovoButton;
import com.lovo.netCRM.component.LovoDate;
import com.lovo.netCRM.component.LovoTable;
import com.lovo.netCRM.component.LovoTitleLabel;
import com.lovo.netCRM.component.LovoTxtArea;

/**
 * 
 * 宿舍管理系统
 * @author 张成峰
 * @version 1.0
 * @see  
 * @description 房间设施对话框
 */
public class RoomSetDialog extends JDialog{
	/**房间主面板*/
	private RoomPanel roomPanel;
	/**设施表格*/
	private LovoTable roomSetTable;
	/**损坏描述文本域*/
	private LovoTxtArea descriptionTxt = new LovoTxtArea("损坏描述",80,340,200,100,this);
	/**房间Id*/
	private int roomId;
	
	public RoomSetDialog(JFrame jf,int roomId,RoomPanel roomPanel){
		super(jf,true);
		this.roomId = roomId;
		this.roomPanel = roomPanel;
	
		this.setLayout(null);
		
		this.init();
		
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) screensize.getWidth() / 2 - 260;
		int y = (int) screensize.getHeight() / 2 - 300;
		this.setBounds(x, y, 520, 600);
		this.setVisible(true);
	}
	/**
	 * 初始化
	 *
	 */
	private void init() {
		LovoTitleLabel titleLabel = new LovoTitleLabel("房间设施信息",this);
		titleLabel.setLocation(180, titleLabel.getY());
		this.initTable();
		this.initData(roomId);
		
		LovoButton addButton = new LovoButton(40,470,"添加损坏记录","image/add.png",this);
		addButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				addRoomSet(roomId);
			}});
		
		LovoButton pressButton = new LovoButton(190,470,"处理损坏设施","image/update.png",this);
		pressButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				int key = roomSetTable.getKeyByInt();
//				if(key == -1){
//					JOptionPane.showMessageDialog(null,"请选择行");
//					return;
//				}
				pressRoomSet(key);
			}});
		
		LovoButton cancelButton = new LovoButton(340,470,"退出","image/cancel.png",this);
		cancelButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				RoomSetDialog.this.dispose();
			}});
	}
	
	//-------------------------
	/**
	 * 初始化表格
	 */
	private void initTable() {
		roomSetTable = new LovoTable(this,
				new String[]{"损坏描述","报损日期","是否解决"},
				new String[]{},//学生实体属性名数组 new String[]{"description","errorDate"}
				"");//主键属性名 setId
		roomSetTable.setSizeAndLocation(40, 120, 440, 200);
	}
	/**
	 * 初始化数据
	 * @param roomId 房间ID
	 */
	private void initData(int roomId){
		roomSetTable.updateLovoTable(null);
	}
	/**
	 * 添加损坏记录
	 * @param roomId 房间ID
	 */
	private void addRoomSet(int roomId){
		//验证数据，数据验证失败返回
		
		initData(roomId);
		roomPanel.initData();
	}
	/**
	 * 处理损坏设施
	 * @param roomSetId 损坏设施ID
	 */
	private void pressRoomSet(int roomSetId){
		
		initData(roomId);
		roomPanel.initData();
	}
}
