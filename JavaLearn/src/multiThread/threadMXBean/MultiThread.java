package multiThread.threadMXBean;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

public class MultiThread {
	public static void main(String[] args) {
		//获取Java线程管理 MXBean
		ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
		//不需要获取 同步的 monitor和synchronizer信息，仅获取线程信息和线程的堆栈信息即可。
		ThreadInfo[] threadinfos = threadMXBean.dumpAllThreads(false, false);
		for(ThreadInfo threadinfo : threadinfos){
			System.out.println(threadinfo.getThreadId()+"--" 
		+ threadinfo.getThreadName());
		}
	}
}
