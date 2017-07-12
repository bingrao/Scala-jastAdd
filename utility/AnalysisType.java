package utility;
public enum AnalysisType {
	Normal(0),
	AE(1),
	RD(2),
	VB(3),
	LV(4);
	private int index;
	private AnalysisType(int idx){
		this.index = idx;
	}
	public int getValue()
	{
		return index;
	}
}