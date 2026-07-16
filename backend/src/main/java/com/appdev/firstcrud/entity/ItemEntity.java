@Entity
@Table(name="item")
public class ItemEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int itemid;
	private String name;
	private String unit;
	private float price;

	public ItemEntity() {
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getItemid() {
		return itemid;
	}

	public String getName() {
		return name;
	}

	public String getUnit() {
		return unit;
	}

	public float getPrice() {
		return price;
	}
}
