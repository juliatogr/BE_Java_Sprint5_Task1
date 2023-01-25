package cat.itacademy.barcelonactiva.tortosa.julia.s05.t01.n01.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cat.itacademy.barcelonactiva.tortosa.julia.s05.t01.n01.models.domain.Sucursal;

@Configuration
class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(SucursalRepository repository) {

    return args -> {
      log.info("Preloading " + repository.save(new Sucursal("Caixabank", "Espanya")));
      log.info("Preloading " + repository.save(new Sucursal("Santander", "Espanya")));
      log.info("Preloading " + repository.save(new Sucursal("Pichincha", "Mèxic")));
    };
  }
}
