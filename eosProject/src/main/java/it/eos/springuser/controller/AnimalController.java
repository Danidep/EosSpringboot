package it.eos.springuser.controller;

@RestController
@RequestMapping("/api")
public class AnimalController {

    @Autowired
    AnimalService repository;

    @PostMapping("/animal")
    public ResponseEntity<AnimalModel> createAnimal(@RequestBody AnimalModel animal){
        return ResponseEntity.ok(repository.save(animal));
    }

    @GetMapping("/animal/{id}")
    public ResponseEntity<AnimalModel> getUserById(@PathVariable("id") long id){
        return ResponseEntity.ok(repository.getUserById(id));
    }

    @GetMapping("/animal")
    public ResponseEntity<List<AnimalEntity>> getAllAnimal(){
        return ResponseEntity.ok(repository.getAllAnimal());
    }

    @DeleteMapping("/animal/{id}")
    public ResponseEntity<String> deleteAnimal(@PathVariable("id") long id){
        return ResponseEntity.ok(repository.deleteAnimal(id));
    }

    @PutMapping("/animal")
    public ResponseEntity<AnimalModel> putAnimal(@RequestBody AnimalModel animal){
        return ResponseEntity.ok(repository.putAnimal(animal));
    }
}