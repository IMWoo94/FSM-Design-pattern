package org.example;

public enum LeaveRequestStateV2 {
	Submitted("Submitted"){
		@Override
		public String responsiblePerson(){
			return "Employee";
		}
		@Override
		public LeaveRequestStateV2 nextState(){
			return Escalated;
		}
	},
	Escalated("Escalated"){
		@Override
		public String responsiblePerson(){
			return "Team Leader";
		}
		@Override
		public LeaveRequestStateV2 nextState(){
			return Approved;
		}
	},
	Approved("Approved"){
		@Override
		public String responsiblePerson(){
			return "Department Manger";
		}

		@Override
		public LeaveRequestStateV2 nextState() {
			return this;
		}
	};

	public abstract String responsiblePerson();
	public abstract LeaveRequestStateV2 nextState();
	private final String name;

	LeaveRequestStateV2(String name) {
		this.name = name;
	}
}
