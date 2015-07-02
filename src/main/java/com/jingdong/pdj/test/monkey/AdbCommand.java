/**
 * 
 */
package com.jingdong.pdj.test.monkey;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author liufeng6
 *
 */
public class AdbCommand {
	private Runtime runtime;
	private String device;
	public static final String ADBDEVICES = "adb devices";
	public static final String DEFAULTMONKEYCOMMAND = "adb%sshell monkey -p com.jingdong.pdj -s 1 --throttle 200 --pct-touch 30 --pct-nav 0 --pct-majornav 0 --pct-syskeys 1 --ignore-crashes --ignore-timeouts --ignore-native-crashes -v -v -v 10000";
//	public static final String VIEWAPPPROCESS_MONKEY = "adb%sshell ps | grep -i monkey";
//	public static final String VIEWAPPPROCESS_LOGCAT = "adb%sshell ps | grep -i logcat";
	public static final String VIEWAPPPROCESS = "adb%sshell ps | grep -i %s";
	/**
	 * 
	 */
	public AdbCommand() {
		// TODO Auto-generated constructor stub
		runtime = Runtime.getRuntime();
	}

	public String getDevices() {
		Process p;
		String deviceId = "E|";
		try {
			p = runtime.exec(ADBDEVICES);
			BufferedInputStream bis = new BufferedInputStream(p.getInputStream());
			byte[] buf = new byte[1024];
			int len = bis.read(buf);
			String[] strs = new String(buf,0,len).split("\r\n");
			if (strs[0].indexOf("List of devices attached") == -1) {
				System.out.println("ADB命令不能使用，请配置SDK环境");
				return "E|ADB命令不能使用，请配置SDK环境";
			}
			if (strs.length < 2){
				System.out.println("没有设备连接，请连接设备");
				return "E|没有设备连接，请连接设备";
			}
			for (int i = 1; i <= strs.length; i++) {
//				deviceIds = new String[strs.length];
				if(strs[i].indexOf("device") > 0) {
					deviceId = strs[i].split("\t")[0];
					return "T|" + deviceId;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return deviceId;
		}
		return deviceId;
	}
	
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		AdbCommand adb = new AdbCommand();
//		String deviceId = adb.getDevices();
////		adb.execCommandNoReturn("adb shell monkey  -p com.jingdong.pdj  -s 1 --throttle 200 --pct-touch 30 --pct-nav 0 --pct-majornav 0 --pct-syskeys 1 --ignore-crashes --ignore-timeouts --ignore-native-crashes -v -v -v 9999999");
////		String str = adb.execCommand("adb shell ps | grep -i monkey");
//		System.out.println(deviceId);
//	}
	
	public Process execCommandNoReturn(String command) {
		Process p = null;
		try {
			p = runtime.exec(command);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}
	
	public String execCommand(String command) {
		Process p;
		String line = null;
		StringBuffer sb = new StringBuffer();
		String ret = "";
		try {
			p = runtime.exec(command);
			BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (sb.length() > 0){
			ret = sb.toString();
		}
		return ret;
	}
	
	public void execCommandAndSave(String command, String filepath) {
		Process p;
		String line = null;
		File f = null;
		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			if(!checkFile(filepath)) {
				f = makeFile(filepath);
			}else{
				f = new File(filepath);
			}
			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f,true)));
			p = runtime.exec(command);
			br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			while ((line = br.readLine()) != null) {
				bw.append(line);
				bw.newLine();
				bw.flush();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} finally {
			try {
				if(bw != null) bw.close();
				if(br != null) br.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}

	public String getCurrentDirectory() {
		return System.getProperty("user.dir");
	}
	
	public void makeDirectory(String dir) {
		String dir1 = getCurrentDirectory() + "\\" + dir;
		File f = new File(dir1);
		if (!f.exists()) {
			f.mkdir();
		}
	}
	
	public File makeFile(String filepath) {
		File f = null;
		f = new File(filepath);
		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return f;
	}
	
	public boolean checkFile(String filepath) {
		File f = new File(filepath);
		if (f.exists() && f.isFile()) {
			return true;
		}
		return false;
	}
	
	public String getCurrentSystemTime() {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd_HHmmss");
		long ctime = System.currentTimeMillis();
	    return format.format(new Date(ctime));
	}
	
	public void killProcess(String deviceId,String processName) {
		String cmd = String.format(VIEWAPPPROCESS, " -s "+ deviceId + " ",processName);
		String processStr = this.execCommand(cmd);
		if (!processStr.equals("")) {
	      String[] p = processStr.split(" ");
	      for (int i = 0; i < p.length; i++) {
	        if (p[i].matches(".*\\d.*")) {
	        	execCommandNoReturn("adb -s " + deviceId + " shell kill " + p[i]);
	        	return;
	        }
	      }
	    }
	}
}
