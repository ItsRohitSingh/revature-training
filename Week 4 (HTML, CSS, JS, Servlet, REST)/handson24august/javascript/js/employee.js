export class Employee {
    constructor(name, age, gender, designation, salary) {
        this.name = name;
        this.age = age;
        this.designation = designation;
        this.salary = salary;
        this.gender = gender;
    }

    display(gen) {
        console.log("Name : "+this.name+", Age : "+this.age+", "+gen+", Designation : "+this.designation+", Salary : "+this.salary);
    }
    
}

export class Gender {
    constructor(code, name) {
        this.code = code;
        this.name = name;
    }

    display() {
        console.log("Code : "+this.code+" Gender : "+this.name);
    }
}