package utility;

public enum Type {
	Int("Int",0),
	Bool("Boolean",1),
	Any("TypeAny",2),
	Unknown("TypeUnknown",100),
	Error("TypeError",101);
	
	private String name;
	private int index;
	private Type(String name,int idx){
		this.name = name;
		this.index = idx;
	}
	public static String getName(int index){
		for(Type t : Type.values()){
			if(t.getIndex() == index)
				return t.getName();
		}
		return null;
	}
	public static boolean isValue(String type){
		for(Type t : Type.values()){
			if(t.getName().equals(type))
				return true;
		}
		return false;
	}
	public static Type getType(String type){
		for(Type t : Type.values()){
			if(t.getName().equals(type))
				return t;
		}
		return Type.Error;
	}
	public static Type getType(int index){
		for(Type t : Type.values()){
			if(t.getIndex() == index)
				return t;
		}
		return Type.Error;
	}
	
	/*get and set function*/
	public String getName() {
	      return name;
	}
	public void setName(String name) {
	      this.name = name;
    }
	public int getIndex() {
	      return index;
    }
	public void setIndex(int index) {
	      this.index = index;
	}
}
