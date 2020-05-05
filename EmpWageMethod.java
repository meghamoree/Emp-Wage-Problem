public class EmpWageMethod {
    //CONSTANTS
    public static final int IS_PART_TIME=1;
    public static final int IS_FULL_TIME=2;

    private int numOfCompany=0;
    public CompanyEmpWage[] companyEmpWageArray;

    public EmpWageMethod() {
        companyEmpWageArray =new CompanyEmpWage[5];

    }

    private void addCompanyEmpWage(String company, int empRatePerHour, int numOfWorkingDay,int maxHoursPerMonth) {
        companyEmpWageArray[numOfCompany] = new CompanyEmpWage(company,empRatePerHour,numOfWorkingDay,maxHoursPerMonth);
        numOfCompany++;
    }

    public void computeEmpWage() {
        for ( int i = 0; i < numOfCompany; i++) {
            int totalEmpWage = this.computeEmpWage(companyEmpWageArray[i]);
            System.out.println(" Total Emp Wage For Company " +companyEmpWageArray[i].company + " is: " +totalEmpWage);
        }
    }

    public int computeEmpWage(CompanyEmpWage companyEmpWage) {
        //variables

        int empHrs=0;
        int totalWorkingDays=0;
        int totalEmpHrs=0;

        //COMPUTATION
        while (totalEmpHrs <= companyEmpWage.maxHoursPerMonth && totalWorkingDays < companyEmpWage.numOfWorkingDays) {
            totalWorkingDays++;
            int empCheck= (int) Math.floor(Math.random()*10) %3;
            switch(empCheck) {
                case  IS_FULL_TIME:
                    empHrs=8;
                    break;
                case IS_PART_TIME:
                    empHrs=4;
                    break;
                default:
                    empHrs=0;
            }
            totalEmpHrs += empHrs;
            System.out.println("Day#: " + totalWorkingDays+ " Emp Hr : " +empHrs);
        }
        return totalEmpHrs= (totalEmpHrs * companyEmpWage.empRatePerHour);
    }

    public static void main(String[] args) {

        EmpWageMethod empWageMethod =new EmpWageMethod();
        empWageMethod.addCompanyEmpWage( "DMart", 20, 20, 10);
        empWageMethod.addCompanyEmpWage( "BigBasket", 30, 20, 20);
        empWageMethod.computeEmpWage();
    }

    private class CompanyEmpWage {
        public String company;
        public int empRatePerHour;
        public int numOfWorkingDays;
        public int maxHoursPerMonth;

        public CompanyEmpWage(String company, int empRatePerHour, int numOfWorkingDay,int maxHoursPerMonth) {
            this.company=company;
            this.empRatePerHour=empRatePerHour;
            this.numOfWorkingDays=numOfWorkingDays;
            this.maxHoursPerMonth=maxHoursPerMonth;
        }
    }

}
