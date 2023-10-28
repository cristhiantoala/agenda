package dagatecompany.agenda.controller;

import dagatecompany.agenda.model.Contacto;
import dagatecompany.agenda.repository.ContactoRepository;
import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
=======
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
>>>>>>> 2745562bca63603c9b3a057becc04471228b6d63
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
<<<<<<< HEAD
=======
import org.springframework.web.bind.annotation.RequestParam;
>>>>>>> 2745562bca63603c9b3a057becc04471228b6d63
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.thymeleaf.model.IModel;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class ContactoController {

    @Autowired
    private ContactoRepository contactoRepository;

    @GetMapping
<<<<<<< HEAD
    String index(Model model) {
        List<Contacto> contactos = contactoRepository.findAll();
        model.addAttribute("contactos", contactos);
=======
    String index(@PageableDefault(size = 4, sort = "fechaRegistro", direction = Sort.Direction.DESC)
                 Pageable pageable,
                 @RequestParam(required = false) String busqueda,
                 Model model
    ) {
        Page<Contacto> contactoPage;
        if (busqueda!= null && busqueda.trim().length() >0){
            contactoPage= contactoRepository.findByNombreContaining(busqueda,pageable);
        }
        else {
            contactoPage=contactoRepository.findAll(pageable);
        }
        model.addAttribute("contactoPage", contactoPage);
>>>>>>> 2745562bca63603c9b3a057becc04471228b6d63
        return "index";
    }

    @GetMapping("/nuevo")
    String nuevo(Model model) {
        model.addAttribute("contacto", new Contacto());
        return "nuevo";
    }

    @PostMapping("/nuevo")
    String crear(@Validated Contacto contacto, BindingResult bindingResult, RedirectAttributes ra, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("contacto", contacto);
            return "nuevo";
        }
        contacto.setFechaRegistro(LocalDateTime.now());
        contactoRepository.save(contacto);
        ra.addFlashAttribute("msgExito", "El contacto ha sido creado");
        return "redirect:/";
    }

    @GetMapping("/{id}/editar")
    String editar(@PathVariable Integer id, Model model) {
        Contacto contacto = contactoRepository.getReferenceById(id);
        model.addAttribute("contacto", contacto);
        return "nuevo";
    }

    @PostMapping("/{id}/editar")
    String actualizar(
            @PathVariable Integer id,
            @Validated Contacto contacto,
            BindingResult bindingResult,
            RedirectAttributes ra,
            Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("contacto", contacto);
            return "nuevo";
        }

        Contacto contactoFromDB = contactoRepository.getReferenceById(id);
        contactoFromDB.setNombre(contacto.getNombre());
        contactoFromDB.setCelular(contacto.getCelular());
        contactoFromDB.setEmail(contacto.getEmail());
        contactoFromDB.setFechaNacimiento(contacto.getFechaNacimiento());

        contactoRepository.save(contactoFromDB);
        ra.addFlashAttribute("msgExito", "El contacto se ha actualizado");
        return "redirect:/";
    }
<<<<<<< HEAD
=======

>>>>>>> 2745562bca63603c9b3a057becc04471228b6d63
    @PostMapping("/{id}/eliminar")
    String eliminar(
            @PathVariable Integer id,
            RedirectAttributes ra) {

        Contacto contacto = contactoRepository.getReferenceById(id);
        contactoRepository.delete(contacto);

        ra.addFlashAttribute("msgExito", "El contacto se ha eliminado");
        return "redirect:/";
    }
}
