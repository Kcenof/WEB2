package com.lab.variant.service;

import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;
import com.lab.variant.fridge;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class fridgeService {
    private static final String FILE_PATH = "src/main/resources/fridge_data.json";
    private List<fridge> fridges;
    private Gson gson = new Gson();

    public fridgeService() {
        this.fridges = loadFridges();
    }

    private List<fridge> loadFridges() {
        try (Reader reader = new FileReader(FILE_PATH)) {
            Type listType = new TypeToken<ArrayList<fridge>>(){}.getType();
            return gson.fromJson(reader, listType);
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    private void saveFridges() {
        try (Writer writer = new FileWriter(FILE_PATH)) {
            gson.toJson(fridges, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<fridge> getAll() {
        return fridges;
    }

    public void add(fridge f) {
        f.setId(generateId());
        fridges.add(f);
        saveFridges();
    }

    public void update(fridge f) {
        for (int i = 0; i < fridges.size(); i++) {
            if (fridges.get(i).getId() == f.getId()) {
                fridges.set(i, f);
                break;
            }
        }
        saveFridges();
    }

    public void delete(int id) {
        fridges.removeIf(f -> f.getId() == id);
        saveFridges();
    }

    private int generateId() {
        return fridges.stream().mapToInt(fridge::getId).max().orElse(0) + 1;
    }
}
