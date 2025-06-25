package com.codegym;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/songs")
public class SongController {

    @Autowired
    private SongRepository songRepository;

    // Display form to add new song
    @GetMapping("/new")
    public String showAddForm(Model model) {
        model.addAttribute("song", new Song());
        return "song-form";
    }

    // Handle form submission for adding new song
    @PostMapping
    public String addSong(@Valid @ModelAttribute Song song, BindingResult result) {
        if (result.hasErrors()) {
            return "song-form";
        }
        songRepository.save(song);
        return "redirect:/songs";
    }

    // Display form to edit song
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Song song = songRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid song Id:" + id));
        model.addAttribute("song", song);
        return "song-form";
    }

    // Handle form submission for updating song
    @PostMapping("/update/{id}")
    public String updateSong(@PathVariable Long id, @Valid @ModelAttribute Song song,
                             BindingResult result) {
        if (result.hasErrors()) {
            song.setId(id);
            return "song-form";
        }
        songRepository.save(song);
        return "redirect:/songs";
    }

    // Display list of songs
    @GetMapping
    public String listSongs(Model model) {
        model.addAttribute("songs", songRepository.findAll());
        return "song-list";
    }
}