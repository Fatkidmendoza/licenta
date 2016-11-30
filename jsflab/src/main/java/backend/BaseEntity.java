package backend;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(
	    name="discriminator",
	    discriminatorType=DiscriminatorType.STRING
	)
@DiscriminatorValue(value="B")
public class BaseEntity extends AbstractModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -167746461311908017L;
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "id", nullable = false, unique = true)
	private Long id;
	
	public BaseEntity(){
		this(null);
	}
	public BaseEntity(final Long id){
		super();
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	
	
}
