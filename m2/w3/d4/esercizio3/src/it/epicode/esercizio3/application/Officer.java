package it.epicode.esercizio3.application;

public abstract class Officer {

	 private int salary;
	    private Officer superior;
	    
	    public Officer(int salary) {
	        this.salary = salary;
	    }
	    
	    public void setSuperior(Officer superior) {
	        this.superior = superior;
	    }
	    
	    public int getSalary() {
	        return salary;
	    }
	    
	    public boolean canHandleRequest(int amount) {
	        return amount <= salary;
	    }
	    
	    public void handleRequest(int amount) {
	        if (canHandleRequest(amount)) {
	            System.out.println(this.getClass().getSimpleName() + " can handle the request.");
	        } else if (superior != null) {
	            superior.handleRequest(amount);
	        } else {
	            System.out.println("None of the officers can handle the request.");
	        }
	    }
}
