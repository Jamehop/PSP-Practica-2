package Main;
import java.util.ArrayList;
import java.util.List;


public class TaskManager {
		List<Long> list;
		int maxSize;
		
		public List<Long> getList() {
			return list;
		}
		public void setList(List<Long> list) {
			this.list = list;
		}
		public int getMaxSize() {
			return maxSize;
		}
		public void setMaxSize(int maxSize) {
			this.maxSize = maxSize;
		}
		public TaskManager(int size) {
			this.list=new ArrayList<Long>();
			this.maxSize=size;
		}
		public synchronized Long extract() {
			return list.remove(0);
		}
		public synchronized void write(Long data) {
			if(list.size()<maxSize);
			list.add(data);
		}
}
