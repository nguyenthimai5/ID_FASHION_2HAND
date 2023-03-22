package ra.dev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.dev.dto.respone.GetCatalog;
import ra.dev.model.entity.Catalog;
import ra.dev.model.service.CatalogService;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/v1/catalog")
public class CatalogController {
    @Autowired
    CatalogService catalogService;

    @GetMapping()
    public List<GetCatalog> getAll() {
        return catalogService.getAll();
    }

    @GetMapping("/{catalogID}")
    public Catalog finById(@PathVariable("catalogID") int catalogId) {
        return catalogService.getById(catalogId);
    }

    @PostMapping
    public Catalog createCatalog(@RequestBody Catalog catalog) {
        return catalogService.save(catalog);
    }

    @PutMapping("/{catalogID}")
    public Catalog updateCatalog(@PathVariable("catalogID") int catalogId, @RequestBody Catalog catalog) {
        return catalogService.update(catalogId, catalog);
    }

    @GetMapping("/lockCatalog/{catalogID}")
    public ResponseEntity<?> deleteCatalog(@PathVariable("catalogID") int catalogId) {
        catalogService.delete(catalogId);
        return ResponseEntity.ok("Lock catagory successfully!");
    }

    @GetMapping("/action")
    public Map<String, Object> paginationCatalog(@RequestParam(defaultValue = "0") String search,
                                                 @RequestParam(defaultValue = "0") String sort,
                                                 @RequestParam(defaultValue = "0") String pagination,
                                                 @RequestParam(defaultValue = "c") String name,
                                                 @RequestParam(defaultValue = "desc") String direction,
                                                 @RequestParam(defaultValue = "0") int page,
                                                 @RequestParam(defaultValue = "3") int size
    ) {
        return catalogService.getPagging(search,sort,pagination,name,direction,page, size);
    }


}
