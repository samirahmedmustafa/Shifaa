/**
 * This file was generated by the Jeddict
 */
package entity.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author sawad
 */
@Entity
public class Clinic implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Basic
    private String name;

    @Basic
    private String phones;

    @Basic
    private String image;

    @ManyToOne
    private Area area;

    public Clinic() {
    }

    @OneToMany(mappedBy = "clinic")
    private List<Doctor> doctors;

    @ManyToMany
    private List<ClinicService> clinicServices;

    @ManyToMany
    private List<Insurance> insurances;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhones() {
        return this.phones;
    }

    public void setPhones(String phones) {
        this.phones = phones;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Area getArea() {
        return this.area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public List<Doctor> getDoctors() {
        if (doctors == null) {
            doctors = new ArrayList<>();
        }
        return this.doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    public void addDoctor(Doctor doctor) {
        getDoctors().add(doctor);
        doctor.setClinic(this);
    }

    public void removeDoctor(Doctor doctor) {
        getDoctors().remove(doctor);
        doctor.setClinic(null);
    }

    public List<ClinicService> getClinicServices() {
        if (clinicServices == null) {
            clinicServices = new ArrayList<>();
        }
        return this.clinicServices;
    }

    public void setClinicServices(List<ClinicService> clinicServices) {
        this.clinicServices = clinicServices;
    }

    public void addClinicService(ClinicService clinicService) {
        getClinicServices().add(clinicService);
        clinicService.getClinics().add(this);
    }

    public void removeClinicService(ClinicService clinicService) {
        getClinicServices().remove(clinicService);
        clinicService.getClinics().remove(this);
    }

    public List<Insurance> getInsurances() {
        if (insurances == null) {
            insurances = new ArrayList<>();
        }
        return this.insurances;
    }

    public void setInsurances(List<Insurance> insurances) {
        this.insurances = insurances;
    }

    public void addInsurance(Insurance insurance) {
        getInsurances().add(insurance);
        insurance.getClinics().add(this);
    }

    public void removeInsurance(Insurance insurance) {
        getInsurances().remove(insurance);
        insurance.getClinics().remove(this);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Clinic other = (Clinic) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Clinic{" + "name=" + name + '}';
    }

}