package lt.akademija.App.Services;



//@Service
//public class ExampleService {
//    @Autowired
//    PhaseRepository repository;
//
//    @Transactional
//    public Phase create(Phase entity) {
//        return repository.save(entity);
//    }
//
//    @Transactional(rollbackFor = EntityNotFound.class)
//    public Phase delete(int id) throws EntityNotFound {
//        Phase deleted = repository.findOne(id);
//        if (deleted == null) {
//            throw new EntityNotFound();
//        }
//        repository.delete(deleted);
//        return deleted;
//    }
//
//    @Transactional(rollbackFor = EntityNotFound.class)
//    public Phase update(Phase entity) throws EntityNotFound {
//        Phase updated = repository.findOne(entity.getId());
//
//        if (updated == null) {
//            throw new EntityNotFound();
//        }
//
//        repository.saveAndFlush(entity);
//        return updated;
//    }
//
//    public Phase findById(int id) throws EntityNotFound {
//        Phase entity = repository.findOne(id);
//
//        if (entity == null) {
//            throw new EntityNotFound();
//        }
//
//        return entity;
//    }
//}