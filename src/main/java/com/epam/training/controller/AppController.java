package com.epam.training.controller;

import com.epam.training.model.Client;
import com.epam.training.service.ClientService;
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

        List<Client> clients = clientService.findAllClients();
        model.addAttribute("clients", clients);
        return "allclients";
    }

    @RequestMapping(value = {"/new"}, method = RequestMethod.GET)
    public String newClient(ModelMap model) {
        Client client = new Client();
        model.addAttribute("client", client);
        model.addAttribute("edit", false);
        return "registration";
    }

    @RequestMapping(value = {"/new"}, method = RequestMethod.POST)
    public String saveClient(@Valid Client client, BindingResult result, ModelMap model) {

        if (result.hasErrors()) {
            return "registration";
        }

        if (!clientService.isClientNameUnique(client.getId(), client.getName())) {
            FieldError nameError = new FieldError("client", "name", messageSource
                    .getMessage("non.unique.name", new String[]{client.getName()}, Locale.getDefault()));
            result.addError(nameError);
            return "registration";
        }

        clientService.saveClient(client);

        model.addAttribute("success", "Client " + client.getName() + " registered successfully");
        return "success";
    }

    @RequestMapping(value = {"/edit-{name}-client"}, method = RequestMethod.GET)
    public String editClient(@PathVariable String name, ModelMap model) {
        Client client = clientService.findClientByName(name);
        model.addAttribute("client", client);
        model.addAttribute("edit", true);
        return "registration";
    }

    @RequestMapping(value = {"/edit-{name}-client"}, method = RequestMethod.POST)
    public String updateClient(@Valid Client client, BindingResult result, ModelMap model, @PathVariable String name) {

        if (result.hasErrors()) {
            return "registration";
        }

        if (!clientService.isClientNameUnique(client.getId(), client.getName())) {
            FieldError nameError = new FieldError("client", "name", messageSource
                    .getMessage("non.unique.name", new String[]{client.getName()}, Locale.getDefault()));
            result.addError(nameError);
            return "registration";
        }

        clientService.updateClient(client);

        model.addAttribute("success", "Client " + client.getName() + " updated successfully");
        return "success";
    }

    @RequestMapping(value = {"/delete-{name}-client"}, method = RequestMethod.GET)
    public String deleteClient(@PathVariable String name) {
        clientService.deleteClientByName(name);
        return "redirect:/list";
    }

}
