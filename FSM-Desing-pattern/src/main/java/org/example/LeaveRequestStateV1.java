package org.example;

public enum LeaveRequestStateV1 {
	Submitted("Submitted"){
		@Override
		public String responsiblePerson(){
			return "Employee";
		}
		@Override
		public void testMethod(){
			System.out.println("test");
		}
	},
	Escalated("Escalated"){
		@Override
		public String responsiblePerson(){
			return "Team Leader";
		}
		@Override
		public void testMethod(){
			System.out.println("test");
		}
	},
	Approved("Approved"){
		@Override
		public String responsiblePerson(){
			return "Department Manger";
		}

		@Override
		public void testMethod() {

		}
	};

	public abstract String responsiblePerson();
	public abstract void testMethod();
	private final String name;

	LeaveRequestStateV1(String name) {
		this.name = name;
	}
}
