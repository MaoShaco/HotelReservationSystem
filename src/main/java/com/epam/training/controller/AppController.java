package com.epam.training.controller;

import com.epam.training.model.ClientEntity;
import com.epam.training.service.ClientService;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/")
public class AppController {

    @Autowired
    ClientService clientService;

    @Autowired
    MessageSource messageSource;

    @RequestMapping(value = {"/", "/list"}, method = RequestMethod.GET)
    public String listClients(ModelMap model) {

        List<ClientEntity> clientEntities = clientService.findAllClients();
        List<ClientEntity> c = clientService.findClientsByRoomNumbersOnDate(1, 100, new LocalDate());
        return "allclients";
    }

    @RequestMapping(value = {"/new"}, method = RequestMethod.GET)
    public String newClient(ModelMap model) {
        ClientEntity clientEntity = new ClientEntity();
        model.addAttribute("clientEntity", clientEntity);
        model.addAttribute("edit", false);
        return "registration";
    }

    @RequestMapping(value = {"/new"}, method = RequestMethod.POST)
    public String saveClient(@Valid ClientEntity clientEntity, BindingResult result, ModelMap model) {

        if (result.hasErrors()) {
            return "registration";
        }

        if (!clientService.isClientNameUnique(clientEntity.getId(), clientEntity.getName())) {
            FieldError nameError = new FieldError("clientEntity", "name", messageSource
                    .getMessage("non.unique.name", new String[]{clientEntity.getName()}, Locale.getDefault()));
            result.addError(nameError);
            return "registration";
        }

        clientService.saveClient(clientEntity);

        model.addAttribute("success", "ClientEntity " + clientEntity.getName() + " registered successfully");
        return "success";
    }

    @RequestMapping(value = {"/edit-{name}-clientEntity"}, method = RequestMethod.GET)
    public String editClient(@PathVariable String name, ModelMap model) {
        ClientEntity clientEntity = clientService.findClientByName(name);
        model.addAttribute("clientEntity", clientEntity);
        model.addAttribute("edit", true);
        return "registration";
    }

    @RequestMapping(value = {"/edit-{name}-clientEntity"}, method = RequestMethod.POST)
    public String updateClient(@Valid ClientEntity clientEntity, BindingResult result, ModelMap model, @PathVariable String name) {

        if (result.hasErrors()) {
            return "registration";
        }

        if (!clientService.isClientNameUnique(clientEntity.getId(), clientEntity.getName())) {
            FieldError nameError = new FieldError("clientEntity", "name", messageSource
                    .getMessage("non.unique.name", new String[]{clientEntity.getName()}, Locale.getDefault()));
            result.addError(nameError);
            return "registration";
        }

        clientService.updateClient(clientEntity);

        model.addAttribute("success", "ClientEntity " + clientEntity.getName() + " updated successfully");
        return "success";
    }

    @RequestMapping(value = {"/delete-{name}-clientEntity"}, method = RequestMethod.GET)
    public String deleteClient(@PathVariable String name) {
        clientService.deleteClientByName(name);
        return "redirect:/list";
    }

}
