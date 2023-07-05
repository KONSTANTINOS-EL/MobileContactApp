package model;

public abstract class AbstractEntity implements IdentifierEntity{
    private  long id;

    @Override
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
}
