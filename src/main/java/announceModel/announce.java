package announceModel;

//Announce model
public class announce {
	
	   //private variables
		private int id;
		private String name;
		private String announce;
		private String grade;
		private String date;
		private String subject;
		
		
		public announce(String name, String announce, String grade, String date,String subject) {
			super();
			this.name = name;
			this.announce = announce;
			this.grade = grade;
			this.date = date;
			this.subject = subject;
		}
		public announce(int id, String name, String announce, String grade, String date,String subject) {
			super();
			this.id = id;
			this.name = name;
			this.announce = announce;
			this.grade = grade;
			this.date = date;
			this.subject = subject;
		}
		
		//Getter and Setters
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getAnnounce() {
			return announce;
		}
		public void setAnnounce(String announce) {
			this.announce = announce;
		}
		public String getGrade() {
			return grade;
		}
		public void setGrade(String grade) {
			this.grade = grade;
		}
		
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}
		
		public String getSubject() {
			return subject;
		}
		public void setSubject(String date) {
			this.date = subject;
		}



}
