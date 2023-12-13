Medical Center (logo)

Person
+Name : String 
+ DateOfBirth: Date

User:((?)
+User ID: String
+Login: String
+PassWord: String


•	DoctorPerson(extend to Person)
o	dateEmplyed: date
o	Specialty: String
o	Rate:Int
o	ID
o	Department
o	Method:
	setDateEmployed
	setSpecialty
	setRate
	setDoctor(Sting,Date,Date,String,Int)
	getDateEmployed
	getSepcialty
	getRate
	getDoctor(Sting,Date,Date,String,Int)
•	PatientPerson(extend to Person)
o	medicardNumber:String
o	issuranceCompeny:Sting
o	appliantID?:String
o	Method:
	setMedicarNumber
	setIssuranceCompeny
	setID
	setPatient(Sring,Date,String,Sting)
	getMedicarNumber
	getissuranceCompeny
	getPatient(Sring,Date,String,Sting)
•	Appointment/reception 
o	Time: Date
o	Doctor: String
o	Specialty: Sting
o	Patient: Sting
	Method:
•	setAppointmentTime
•	setAppointmentDoctor
•	setAppointment{atient
•	setAppointment(date,string,sting)
•	getAppointmentTime
•	getAppointmentDoctor
•	getAppointmentPatient
•	getAppointment (date, stirng,string)
Treatment:
•	Doctor:String
•	Patient:String
•	startdate:date
•	enddate: date
o	Method:
o	setTreatmentDoctor
o	setTreatmentPatient
o	setTreatmentDate
o	steTreatment(String,String,date,date)
o	getTreatmentDoctor
o	getTreatmentPatient
o	getTreatmentDate

