package multiThread.threadMXBean;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

public class MultiThread {
	public static void main(String[] args) {
		//��ȡJava�̹߳��� MXBean
		ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
		//����Ҫ��ȡ ͬ���� monitor��synchronizer��Ϣ������ȡ�߳���Ϣ���̵߳Ķ�ջ��Ϣ���ɡ�
		ThreadInfo[] threadinfos = threadMXBean.dumpAllThreads(false, false);
		for(ThreadInfo threadinfo : threadinfos){
			System.out.println(threadinfo.getThreadId()+"--" 
		+ threadinfo.getThreadName());
		}
	}
}
