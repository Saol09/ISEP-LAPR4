package eapli.base.costumermanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;


/**
 * The type Gender.
 */
@Embeddable
public class Gender implements ValueObject {
    private String gender;

    /**
     * Instantiates a new Gender.
     *
     * @param genderNum the gender num
     */
    public Gender(int genderNum) {
        setGender(genderNum);
    }

    /**
     * Instantiates a new Gender.
     */
    protected Gender() {
        // for ORM only
    }


    private void setGender(int num) {
        switch (num) {
            case 1:
                this.gender = "Female";
                break;
            case 2:
                this.gender = "Male";
                break;
            case 3:
                this.gender = "Other";
                break;
            default:
                this.gender = "Not inserted";
                break;
        }
    }
}
