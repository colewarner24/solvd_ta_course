package internetShop.utility;

import java.util.HashSet;
import java.util.Set;

public class IDManager {

    private int lastAssignedId = 0; // Track the last assigned ID
    private Set<Integer> usedIds = new HashSet<>(); // Track used IDs

    public int assignId() {
        lastAssignedId++;
        while (usedIds.contains(lastAssignedId)) {
            lastAssignedId++;
        }
        usedIds.add(lastAssignedId);
        return lastAssignedId;
    }

    public void assignId(int id) throws Exception {
        if (id < 0 || usedIds.contains(id)) {
            throw new Exception("ID is already in use or invalid");
        }
        usedIds.add(id);
    }

    public boolean isIdUsed(int id) {
        return usedIds.contains(id);
    }
}