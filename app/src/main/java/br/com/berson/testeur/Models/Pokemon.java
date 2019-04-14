
package br.com.berson.testeur.Models;

import java.io.Serializable;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pokemon implements Serializable, Parcelable
{

    @SerializedName("abilities")
    @Expose
    private List<Ability> abilities = null;
    @SerializedName("base_experience")
    @Expose
    private Integer baseExperience;
    @SerializedName("forms")
    @Expose
    private List<Form> forms = null;
    @SerializedName("game_indices")
    @Expose
    private List<GameIndex> gameIndices = null;
    @SerializedName("height")
    @Expose
    private Integer height;
    @SerializedName("held_items")
    @Expose
    private List<HeldItem> heldItems = null;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("is_default")
    @Expose
    private Boolean isDefault;
    @SerializedName("location_area_encounters")
    @Expose
    private String locationAreaEncounters;
    @SerializedName("moves")
    @Expose
    private List<Move> moves = null;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("order")
    @Expose
    private Integer order;
    @SerializedName("species")
    @Expose
    private Species species;
    @SerializedName("sprites")
    @Expose
    private Sprites sprites;
    @SerializedName("stats")
    @Expose
    private List<Stat> stats = null;
    @SerializedName("types")
    @Expose
    private List<Type> types = null;
    @SerializedName("weight")
    @Expose
    private Integer weight;
    public final static Parcelable.Creator<Pokemon> CREATOR = new Creator<Pokemon>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Pokemon createFromParcel(Parcel in) {
            return new Pokemon(in);
        }

        public Pokemon[] newArray(int size) {
            return (new Pokemon[size]);
        }

    }
    ;
    private final static long serialVersionUID = -5747108332926241848L;

    protected Pokemon(Parcel in) {
        in.readList(this.abilities, (br.com.berson.testeur.Models.Ability.class.getClassLoader()));
        this.baseExperience = ((Integer) in.readValue((Integer.class.getClassLoader())));
        in.readList(this.forms, (br.com.berson.testeur.Models.Form.class.getClassLoader()));
        in.readList(this.gameIndices, (br.com.berson.testeur.Models.GameIndex.class.getClassLoader()));
        this.height = ((Integer) in.readValue((Integer.class.getClassLoader())));
        in.readList(this.heldItems, (br.com.berson.testeur.Models.HeldItem.class.getClassLoader()));
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.isDefault = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.locationAreaEncounters = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.moves, (br.com.berson.testeur.Models.Move.class.getClassLoader()));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.order = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.species = ((Species) in.readValue((Species.class.getClassLoader())));
        this.sprites = ((Sprites) in.readValue((Sprites.class.getClassLoader())));
        in.readList(this.stats, (br.com.berson.testeur.Models.Stat.class.getClassLoader()));
        in.readList(this.types, (br.com.berson.testeur.Models.Type.class.getClassLoader()));
        this.weight = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    public Pokemon() {
    }

    public List<Ability> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<Ability> abilities) {
        this.abilities = abilities;
    }

    public Integer getBaseExperience() {
        return baseExperience;
    }

    public void setBaseExperience(Integer baseExperience) {
        this.baseExperience = baseExperience;
    }

    public List<Form> getForms() {
        return forms;
    }

    public void setForms(List<Form> forms) {
        this.forms = forms;
    }

    public List<GameIndex> getGameIndices() {
        return gameIndices;
    }

    public void setGameIndices(List<GameIndex> gameIndices) {
        this.gameIndices = gameIndices;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public List<HeldItem> getHeldItems() {
        return heldItems;
    }

    public void setHeldItems(List<HeldItem> heldItems) {
        this.heldItems = heldItems;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }

    public String getLocationAreaEncounters() {
        return locationAreaEncounters;
    }

    public void setLocationAreaEncounters(String locationAreaEncounters) {
        this.locationAreaEncounters = locationAreaEncounters;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    public Sprites getSprites() {
        return sprites;
    }

    public void setSprites(Sprites sprites) {
        this.sprites = sprites;
    }

    public List<Stat> getStats() {
        return stats;
    }

    public void setStats(List<Stat> stats) {
        this.stats = stats;
    }

    public List<Type> getTypes() {
        return types;
    }

    public void setTypes(List<Type> types) {
        this.types = types;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(abilities);
        dest.writeValue(baseExperience);
        dest.writeList(forms);
        dest.writeList(gameIndices);
        dest.writeValue(height);
        dest.writeList(heldItems);
        dest.writeValue(id);
        dest.writeValue(isDefault);
        dest.writeValue(locationAreaEncounters);
        dest.writeList(moves);
        dest.writeValue(name);
        dest.writeValue(order);
        dest.writeValue(species);
        dest.writeValue(sprites);
        dest.writeList(stats);
        dest.writeList(types);
        dest.writeValue(weight);
    }

    public int describeContents() {
        return  0;
    }

}
