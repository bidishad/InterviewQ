package other;

public class Person {
	private String name;
	private String address;
	private String phone;
	
	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((name == null) ? 0 : name.hashCode())
                + (( phone==null) ? 0 : phone.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Person other = (Person) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if(phone ==null){
        	if(other.phone !=null)
        		return false;
        }
        else if (!name.equals(other.name) && !phone.equals(other.phone))
            return false;
        return true;
    }
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
