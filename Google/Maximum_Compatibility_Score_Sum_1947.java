class Solution {
	int maxScore;
	public int maxCompatibilitySum(int[][] students, int[][] mentors) {
		boolean[] assigned = new boolean[students.length];
		assignMentors(assigned, students, mentors, 0, 0);
		return maxScore;
	}

	private void assignMentors(boolean[] assigned, int[][] students, int[][] mentors, int studentNo, int score)     {
		if(studentNo >= students.length){
			maxScore = Math.max(maxScore, score);
			return;
		}
		for(int i = 0; i < mentors.length; i++)
			if(!assigned[i]){
				assigned[i] = true;
				assignMentors(assigned, students, mentors, studentNo + 1, score + score(students[studentNo], mentors[i]));
				assigned[i] = false;
			}
    }
    
	private int score(int[] a, int[] b){
		int count = 0;
		for(int i = 0; i < b.length; i++)
			if(a[i] == b[i]) count += 1;
		return count;
	}
} 