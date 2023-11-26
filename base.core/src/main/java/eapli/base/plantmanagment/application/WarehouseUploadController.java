package eapli.base.plantmanagment.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.plantmanagment.domain.PlantBuilder;
import eapli.base.plantmanagment.domain.WarehousePlant;
import eapli.base.plantmanagment.repository.WarehousePlantRepository;

import java.util.ArrayList;


/**
 * The type Warehouse upload controller.
 */
public class WarehouseUploadController {

    private final WarehousePlantRepository wareRepository = PersistenceContext.repositories().warehousePlantRepository();

    /**
     * Create plant.
     *
     * @param filename the filename
     * @param version  the version
     */
    public void createPlant(final String filename, boolean version){
        if (!version){
            wareRepository.delete(wareRepository.findAll().iterator().next());
        }
        final PlantJsonImport Importer = new PlantJsonImport();
        ArrayList<Object> listVariablesJson = Importer.OrganizePlant(filename);
        PlantBuilder plantBuilder = new PlantBuilder();
        WarehousePlant warehousePlant=plantBuilder.buildNewPlant(listVariablesJson);
        wareRepository.save(warehousePlant);
    }


    /**
     * Show warehouse plant string.
     *
     * @return the string
     */
    public String showWarehousePlant () {
        Iterable<WarehousePlant> warehouse = wareRepository.findAll();

        WarehousePlant warehousePlant = warehouse.iterator().next();



        return warehousePlant.toString();



    }





}
