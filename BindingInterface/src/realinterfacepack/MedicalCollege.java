package realinterfacepack;

class MedicalCollege implements Doctor
{
	@Override
	public void doCure() {
		System.out.println("cure method called...");
	}
}
