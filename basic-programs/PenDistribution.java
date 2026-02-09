class PenDistribution {
    public static void main(String[] args) {
        int TotalPens = 14;
        int TotalStudents = 3;

        int PensPerStudent = TotalPens / TotalStudents;  
        int RemainingPens = TotalPens % TotalStudents;  

        System.out.println("The Pen Per Student is " + PensPerStudent + " and the remaining pen not distributed is " + RemainingPens);
    }
}
