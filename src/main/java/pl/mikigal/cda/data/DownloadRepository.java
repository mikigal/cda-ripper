package pl.mikigal.cda.data;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DownloadRepository extends CrudRepository<Download, Integer> {
    Download findById(int id);
}