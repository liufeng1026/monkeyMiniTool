/**
 * 
 */
package com.jingdong.pdj.test.monkey;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 * @author liufeng6
 *
 */
public class monkeyUI extends JFrame{
	public static String title = "monkey 工具";
	private JPanel contentPane;
	private JTextField textFieldPackageName;
	private JTextField textFieldDeviceName;
	private JTextField textFieldSeed;
	private JTextField textFieldThrottle;
	private JTextField textFieldPctTouch;
	private JTextField textFieldPctMotion;
	private JTextField textFieldPctTracball;
	private JTextField textFieldPctNav;
	private JTextField textFieldPctMajorNav;
	private JTextField textFieldPctSyskey;
	private JTextField textFieldPctActivity;
	private JTextField textFieldpinchzoom;
	private JTextField textFieldCount;
	private JTextArea textAreaCmd;
	

	AdbCommand cmd;
	private String deviceId = "";
	private final static String PACKAGENAME = "com.jingdong.pdj";
	
	/**
	 * 构造UI
	 */
	public monkeyUI() {
		cmd = new AdbCommand();
		if(cmd.getDevices().indexOf("T") > -1) {
			deviceId = cmd.getDevices().substring(2);
		}
		
		
		setTitle(title);
		setDefaultCloseOperation(2);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPackageName = new JLabel("应用名称:");
		lblPackageName.setFont(new Font("宋体", 1, 14));
		lblPackageName.setBounds(50, 25, 140, 25);
	    contentPane.add(lblPackageName);
	    
	    textFieldPackageName = new JTextField();
	    textFieldPackageName.setFont(new Font("宋体", 1, 12));
	    textFieldPackageName.setBounds(140, 25, 140, 25);
	    textFieldPackageName.setText(PACKAGENAME);
	    textFieldPackageName.setBorder(BorderFactory.createLineBorder(Color.BLUE));
	    textFieldPackageName.setEditable(false);
	    contentPane.add(textFieldPackageName);
	    
	    JLabel lblDeviceName = new JLabel("设备信息:");
	    lblDeviceName.setFont(new Font("宋体", 1, 14));
	    lblDeviceName.setBounds(350, 25, 140, 25);
	    contentPane.add(lblDeviceName);
	    
	    textFieldDeviceName = new JTextField();
	    textFieldDeviceName.setFont(new Font("宋体", 1, 12));
	    textFieldDeviceName.setBounds(450, 25, 140, 25);
	    textFieldDeviceName.setText(deviceId);
//	    textFieldDeviceName.setText("test");
	    textFieldDeviceName.setBorder(BorderFactory.createLineBorder(Color.BLUE));
	    textFieldDeviceName.setEditable(false);
	    contentPane.add(textFieldDeviceName);
	    
	    JLabel lblParameters = new JLabel("参数配置:");
	    lblParameters.setFont(new Font("宋体", 1, 14));
	    lblParameters.setBounds(50, 50, 140, 25);
	    contentPane.add(lblParameters);
	    
	    JLabel lblSeed = new JLabel("SEED:");
	    lblSeed.setFont(new Font("宋体", 1, 12));
	    lblSeed.setBounds(50, 75, 140, 25);
	    contentPane.add(lblSeed);
	    
	    this.textFieldSeed = new JTextField();
	    this.textFieldSeed.setDocument(new DigitalDocument());
	    this.textFieldSeed.setText("1");
	    this.textFieldSeed.setBounds(140, 75, 140, 25);
	    this.contentPane.add(this.textFieldSeed);
	    
	    JLabel lblThrottle = new JLabel("延迟(ms):");
	    lblThrottle.setFont(new Font("宋体", 1, 12));
	    lblThrottle.setBounds(50, 100, 140, 25);
	    contentPane.add(lblThrottle);
	    
	    this.textFieldThrottle = new JTextField();
	    this.textFieldThrottle.setDocument(new DigitalDocument());
	    this.textFieldThrottle.setText("500");
	    this.textFieldThrottle.setBounds(140, 100, 140, 25);
	    this.contentPane.add(this.textFieldThrottle);
	    
	    JLabel lblPctTouch = new JLabel("触摸事件(%):");
	    lblPctTouch.setFont(new Font("宋体", 1, 12));
	    lblPctTouch.setBounds(50, 125, 140, 25);
	    contentPane.add(lblPctTouch);
	    
	    this.textFieldPctTouch = new JTextField();
	    this.textFieldPctTouch.setDocument(new DigitalDocument());
	    this.textFieldPctTouch.setText("30");
	    this.textFieldPctTouch.setBounds(140, 125, 140, 25);
	    this.contentPane.add(this.textFieldPctTouch);
	    
	    JLabel lblPctMotion = new JLabel("动作事件(%):");
	    lblPctMotion.setFont(new Font("宋体", 1, 12));
	    lblPctMotion.setBounds(50, 150, 140, 25);
	    contentPane.add(lblPctMotion);
	    
	    this.textFieldPctMotion = new JTextField();
	    this.textFieldPctMotion.setDocument(new DigitalDocument());
	    this.textFieldPctMotion.setBounds(140, 150, 140, 25);
	    this.contentPane.add(this.textFieldPctMotion);
	    
	    JLabel lblPctTracball = new JLabel("轨迹事件(%):");
	    lblPctTracball.setFont(new Font("宋体", 1, 12));
	    lblPctTracball.setBounds(50, 175, 140, 25);
	    contentPane.add(lblPctTracball);
	    
	    this.textFieldPctTracball = new JTextField();
	    this.textFieldPctTracball.setDocument(new DigitalDocument());
	    this.textFieldPctTracball.setBounds(140, 175, 140, 25);
	    this.contentPane.add(this.textFieldPctTracball);
	    
	    JLabel lblFieldPctNav = new JLabel("导航事件(%):");
	    lblFieldPctNav.setFont(new Font("宋体", 1, 12));
	    lblFieldPctNav.setBounds(50, 200, 140, 25);
	    contentPane.add(lblFieldPctNav);
	    
	    this.textFieldPctNav = new JTextField();
	    this.textFieldPctNav.setDocument(new DigitalDocument());
	    this.textFieldPctNav.setBounds(140, 200, 140, 25);
	    this.contentPane.add(this.textFieldPctNav);
	    
	    JLabel lblPctMajorNav = new JLabel("主导航事件(%):");
	    lblPctMajorNav.setFont(new Font("宋体", 1, 12));
	    lblPctMajorNav.setBounds(50, 225, 140, 25);
	    contentPane.add(lblPctMajorNav);
	    
	    this.textFieldPctMajorNav = new JTextField();
	    this.textFieldPctMajorNav.setDocument(new DigitalDocument());
	    this.textFieldPctMajorNav.setBounds(140, 225, 140, 25);
	    this.contentPane.add(this.textFieldPctMajorNav);
	    
	    JLabel lblPctSyskey = new JLabel("系统按键(%):");
	    lblPctSyskey.setFont(new Font("宋体", 1, 12));
	    lblPctSyskey.setBounds(50, 250, 140, 25);
	    contentPane.add(lblPctSyskey);
	    
	    this.textFieldPctSyskey = new JTextField();
	    this.textFieldPctSyskey.setDocument(new DigitalDocument());
	    this.textFieldPctSyskey.setText("1");
	    this.textFieldPctSyskey.setBounds(140, 250, 140, 25);
	    this.contentPane.add(this.textFieldPctSyskey);
	   
	    JLabel lblPctActivity = new JLabel("Activity(%):");
	    lblPctActivity.setFont(new Font("宋体", 1, 12));
	    lblPctActivity.setBounds(50, 275, 140, 25);
	    contentPane.add(lblPctActivity);
	    
	    this.textFieldPctActivity = new JTextField();
	    this.textFieldPctActivity.setDocument(new DigitalDocument());
	    this.textFieldPctActivity.setBounds(140, 275, 140, 25);
	    this.contentPane.add(this.textFieldPctActivity);
	    
	    JLabel lblPinchZoom = new JLabel("其他事件(%):");
	    lblPinchZoom.setFont(new Font("宋体", 1, 12));
	    lblPinchZoom.setBounds(50, 300, 140, 25);
	    contentPane.add(lblPinchZoom);
	    
	    this.textFieldpinchzoom = new JTextField();
	    this.textFieldpinchzoom.setDocument(new DigitalDocument());
	    this.textFieldpinchzoom.setBounds(140, 300, 140, 25);
	    this.contentPane.add(this.textFieldpinchzoom);
	    
	    JLabel lblCount = new JLabel("测试次数:");
	    lblCount.setFont(new Font("宋体", 1, 12));
	    lblCount.setBounds(50, 325, 140, 25);
	    contentPane.add(lblCount);
	    
	    this.textFieldCount = new JTextField();
	    this.textFieldCount.setBounds(140, 325, 140, 25);
	    this.textFieldCount.setDocument(new DigitalDocument());
	    this.textFieldCount.setText("10000");
	    this.textFieldCount.setForeground(new Color(255, 0, 0));
	    this.contentPane.add(this.textFieldCount);
	    
	    JButton btnCreateCommand = new JButton();
	    btnCreateCommand.setFont(new Font("宋体", 1, 18));
	    btnCreateCommand.setBackground(new Color(50, 205, 50));
	    btnCreateCommand.setForeground(new Color(240, 255, 240));
	    btnCreateCommand.setBounds(350, 75, 140, 25);
	    btnCreateCommand.setFocusPainted(false);
	    btnCreateCommand.setText("生成命令");
	    contentPane.add(btnCreateCommand);
	    
	    btnCreateCommand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!"".equals(getParameters())) {
					textAreaCmd.setText(getParameters().trim());
				}
			}
		});
	    
	    JScrollPane scrollPane = new JScrollPane();
	    scrollPane.setBounds(350, 105, 350, 180);
	    this.contentPane.add(scrollPane);
	    
	    this.textAreaCmd = new JTextArea();
	    this.textAreaCmd.setFont(new Font("Monospaced", 0, 16));
	    this.textAreaCmd.setForeground(Color.WHITE);
	    this.textAreaCmd.setBackground(Color.DARK_GRAY);
	    this.textAreaCmd.setText(String.format(AdbCommand.DEFAULTMONKEYCOMMAND," "));
	    scrollPane.setViewportView(this.textAreaCmd);
	    
	    JScrollPane scrollPaneComment = new JScrollPane();
	    scrollPaneComment.setBounds(35, 360, 280, 75);
	    this.contentPane.add(scrollPaneComment);
	    
	    JTextArea textAreaComment = new JTextArea();
	    
	    textAreaComment.setFont(new Font("宋体", 1, 10));
	    textAreaComment.setForeground(Color.red);
	    textAreaComment.setText("说明：\n1.连接手机及装好驱动。\n2.参数全部为整数。\n3.百分比项相加不超100。");
	    textAreaComment.setEditable(false);
	    scrollPaneComment.setViewportView(textAreaComment);
	    
		JButton btnStart = new JButton();
		btnStart.setFont(new Font("宋体", 1, 18));
		btnStart.setBackground(new Color(50, 205, 50));
	    btnStart.setForeground(new Color(240, 255, 240));
	    btnStart.setBounds(360, 350, 140, 50);
	    btnStart.setFocusPainted(false);
	    btnStart.setText("开始");
	    contentPane.add(btnStart);
	    
	    btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				new Thread(new Runnable() {
					public void run() {
						// TODO Auto-generated method stub
						cmd.killProcess(deviceId, "monkey");
					}
				}).start();
				new Thread(new Runnable() {
					public void run() {
						// TODO Auto-generated method stub
						cmd.killProcess(deviceId, "logcat");
					}
				}).start();
				
				
				//1.check the same deviceId
				if(cmd.getDevices().indexOf("E") > -1) {
					JOptionPane.showMessageDialog(null, cmd.getDevices().substring(2), "提示", JOptionPane.ERROR_MESSAGE);
				}
				if(cmd.getDevices().indexOf("T") > -1) {
					if (!deviceId.equals(cmd.getDevices().substring(2))) {
						deviceId = cmd.getDevices().substring(2);
					}
				}
				final String systime =  cmd.getCurrentSystemTime();
				
				new Thread(new Runnable() {
					public void run() {
						// TODO Auto-generated method stub
						String monkeyCmd = "";
						
						monkeyCmd = "adb -s " + deviceId + " " + textAreaCmd.getText().toString().trim().substring(3);
						System.out.println(monkeyCmd);
						//2.sent command to device and return touch event.
						cmd.makeDirectory("report");
						String filename = "MONKEY_" + systime + ".txt";
						String filepath = cmd.getCurrentDirectory() + "\\report\\" + filename; 
						cmd.execCommandAndSave(monkeyCmd, filepath);
					}
				}).start();

				new Thread(new Runnable() {
					public void run() {
						String logcatCmd = "";
						//logcatCmd = "adb -s " + deviceId + " logcat | grep " + textFieldPackageName.getText().toString().trim();
						logcatCmd = "adb -s " + deviceId + " logcat -v time";
						System.out.println(logcatCmd);
						//3.send command and return logcat.txt
						cmd.makeDirectory("log");
						String logcatfilename = "LOGCAT_" + systime + ".txt";
						String logcatfilepath = cmd.getCurrentDirectory() + "\\log\\" + logcatfilename;
						
						cmd.execCommandAndSave(logcatCmd, logcatfilepath);
					}
				
				}).start();
			}
		});
	    
	    JButton btnStop = new JButton();
	    btnStop.setFont(new Font("宋体", 1, 18));
	    btnStop.setBackground(new Color(50, 205, 50));
	    btnStop.setForeground(new Color(240, 255, 240));
	    btnStop.setBounds(550, 350, 140, 50);
	    btnStop.setFocusPainted(false);
	    btnStop.setText("结束");
	    contentPane.add(btnStop);
	    
	    btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//1.check the same deviceId
				if(cmd.getDevices().indexOf("E") > -1) {
					JOptionPane.showMessageDialog(null, cmd.getDevices().substring(2), "提示", JOptionPane.ERROR_MESSAGE);
				}
				if(cmd.getDevices().indexOf("T") > -1) {
					if (!deviceId.equals(cmd.getDevices().substring(2))) {
						deviceId = cmd.getDevices().substring(2);
					}
				}
				new Thread(new Runnable() {
					public void run() {
						// TODO Auto-generated method stub
						cmd.killProcess(deviceId, "monkey");
					}
				}).start();
				new Thread(new Runnable() {
					public void run() {
						// TODO Auto-generated method stub
						cmd.killProcess(deviceId, "logcat");
					}
				}).start();
			}
		});
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		monkeyUI frame = new monkeyUI();
		frame.setVisible(true);
//		System.out.println(System.getProperty("user.dir"));
//		File directory = new File("");
//	    String abPath = directory.getAbsolutePath();
//	    System.out.println("the current absolute path: " + abPath);
	}
	
	private String getParameters() {
		StringBuffer ret = new StringBuffer();
		int defaultCount = 10000;
		ret.append("adb shell monkey");
		if (!"".equals(textFieldPackageName.getText().toString().trim())) {
			ret.append(" -p " + textFieldPackageName.getText().toString().trim());
		}
		if (!"".equals(textFieldSeed.getText().toString().trim())) {
			ret.append(" -s " + textFieldSeed.getText().toString().trim());
		}
		if (!"".equals(textFieldThrottle.getText().toString().trim())) {
			ret.append(" --throttle " + textFieldThrottle.getText().toString().trim());
		}
		if (!"".equals(textFieldPctTouch.getText().toString().trim())) {
			ret.append(" --pct-touch " + textFieldPctTouch.getText().toString().trim());
		}
		if (!"".equals(textFieldPctMotion.getText().toString().trim())) {
			ret.append(" --pct-motion " + textFieldPctMotion.getText().toString().trim());
		}
		if (!"".equals(textFieldPctTracball.getText().toString().trim())) {
			ret.append(" --pct-trackball " + textFieldPctTracball.getText().toString().trim());
		}
		if (!"".equals(textFieldPctNav.getText().toString().trim())) {
			ret.append(" --pct-nav " + textFieldPctNav.getText().toString().trim());
		}
		if (!"".equals(textFieldPctMajorNav.getText().toString().trim())) {
			ret.append(" --pct-majornav " + textFieldPctMajorNav.getText().toString().trim());
		}
		if (!"".equals(textFieldPctSyskey.getText().toString().trim())) {
			ret.append(" --pct-syskeys " + textFieldPctSyskey.getText().toString().trim());
		}
		if (!"".equals(textFieldPctActivity.getText().toString().trim())) {
			ret.append(" --pct-appswitch " + textFieldPctActivity.getText().toString().trim());
		}
		if (!"".equals(textFieldpinchzoom.getText().toString().trim())) {
			ret.append(" --pct-anyevent " + textFieldpinchzoom.getText().toString().trim());
		}
		ret.append(" --ignore-crashes --ignore-timeouts --ignore-native-crashes -v -v -v ");
		if (!"".equals(textFieldCount.getText().toString().trim())) {
			ret.append(textFieldCount.getText().toString().trim());
		}else{
			ret.append(defaultCount);
		}
		return ret.toString();
	}
	
	public boolean checkSingleParameterMaxValue(String value) {
		if(!"".equals(value) || !"".equals(value.trim()) 
				|| Integer.valueOf(value).intValue() < 0 
				|| Integer.valueOf(value).intValue() > 100) {
			return false;
		}
		return true;
	}
	
	public boolean checkAllParameterTotalMaxValue() {
		int pctTouch 	= Integer.valueOf(textFieldPctTouch.getText().toString().trim()).intValue();
		int pctMotion 	= Integer.valueOf(textFieldPctMotion.getText().toString().trim()).intValue();
		int pctTracball = Integer.valueOf(textFieldPctTracball.getText().toString().trim()).intValue();
		int pctNav 		= Integer.valueOf(textFieldPctNav.getText().toString().trim()).intValue();
		int pctMajorNav = Integer.valueOf(textFieldPctMajorNav.getText().toString().trim()).intValue();
		int pctSyskey 	= Integer.valueOf(textFieldPctSyskey.getText().toString().trim()).intValue();
		int pctActivity = Integer.valueOf(textFieldPctActivity.getText().toString().trim()).intValue();
		int pinchzoom 	= Integer.valueOf(textFieldpinchzoom.getText().toString().trim()).intValue();
		if (pctTouch + pctMotion + pctTracball + pctNav + pctMajorNav + pctSyskey + pctActivity + pinchzoom > 100) {
			return false;
		}
		return true;
	}
	
	
	/**----------------------------parameters---------------------
	 * 	触摸事件		textFieldPctTouch
	 * 	动作事件		textFieldPctMotion
	 * 	轨迹事件		textFieldPctTracball
	 * 	导航事件		textFieldPctNav
	 * 	主导航事件		textFieldPctMajorNav
	 * 	系统按键		textFieldPctSyskey
	 * 	Activity	textFieldPctActivity
	 * 	其他事件		textFieldpinchzoom
	 *-----------------------------------------------------------
	 */
}
