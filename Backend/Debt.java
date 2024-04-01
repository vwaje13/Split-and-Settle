import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.HashMap;
import java.util.HashSet;

//Ahmed// Ayush owes Ahmed $10, Ahmed owes Veer $10, so Ayush directly pays Veer $10 to clear Ahmed debt

public class Debt {
    // Fields to store the debt information
    int debtID;
    double amountOwed;
    User debtor; // The user who owes money
    User debtCollector; // The user to whom money is owed
    int groupID; // Identifier for the group where this debt relation exists

    // Constructor to initialize a Debt object with specific details
    Debt(int detID, double amount, User debtLoaner, User dCollector, int grupID){
        debtID = detID; // Assign the debt ID
        amountOwed = amount; // Assign the amount owed
        debtor = debtLoaner; // Assign the debtor
        debtCollector = dCollector; // Assign the debt collector
        groupID = grupID; // Assign the group ID
    }

    List<Debt> viewDebts(int userID, int groupID) {
    // Step 1: Filter debts by groupID and include only those where the user is either a debtor or a collector.
    List<Debt> relevantDebts = null; // Subject to being corrected based off how we store the debts within the user class etc.

    // For now you might need to manually iterate over all debts and select the relevant ones.

    // Steps 2 to 4: Simplify these debts.
    Map<User, Double> netBalances = calculateNetBalances(relevantDebts);
    Map<User, Map<User, Double>> graph = buildGraph(netBalances);
    reduceGraph(graph);
    List<Debt> simplifiedDebts = convertGraphToDebts(graph);

    // Step 5: Return the simplified debts.
    return simplifiedDebts;
}

    // Converts a graph representation of debts into a list of Debt objects
    private List<Debt> convertGraphToDebts(Map<User, Map<User, Double>> graph) {
        List<Debt> simplifiedDebts = new ArrayList<>();
        // Iterate over each debtor in the graph
        for (Map.Entry<User, Map<User, Double>> entry : graph.entrySet()) {
            User debtor = entry.getKey(); // Current debtor
            // Iterate over each debtCollector and the amount they are owed by the current debtor
            for (Map.Entry<User, Double> innerEntry : entry.getValue().entrySet()) {
                User debtCollector = innerEntry.getKey(); // Current debt collector
                Double amount = innerEntry.getValue(); // Amount owed
                if (amount > 0) { // Only consider positive amounts (valid debts)
                    // Create a new Debt object using the overloaded constructor
                    Debt debt = new Debt(0, amount, debtor, debtCollector, 0); // Assuming placeholder values for IDs
                    simplifiedDebts.add(debt); // Add the newly created Debt object to the list
                }
            }
        }
        return simplifiedDebts; // Return the list of simplified Debt objects
    }

    // Reduces the complexity of the debt graph to minimize the total number of transactions
    private void reduceGraph(Map<User, Map<User, Double>> graph) {
        // Iterate over each debtor in the graph
        for (User debtor : graph.keySet()) {
            Map<User, Double> debts = graph.get(debtor); // Get debts for the current debtor
            // Use a copy of the entrySet to avoid concurrent modification exceptions
            for (Map.Entry<User, Double> entry : new HashSet<>(debts.entrySet())) {
                User creditor = entry.getKey(); // Current creditor
                double amount = entry.getValue(); // Amount owed to the current creditor

                if (amount <= 0) {
                    continue; // Skip if no debt is owed to this creditor
                }

                // Attempt to find a chain of debts that can be simplified
                Map<User, Double> credits = graph.get(creditor); // Credits for the current creditor
                for (Map.Entry<User, Double> creditEntry : credits.entrySet()) {
                    User endCreditor = creditEntry.getKey(); // The end creditor in the chain
                    double creditAmount = creditEntry.getValue(); // Amount the current creditor owes to the end creditor

                    if (creditAmount <= 0 || debtor == endCreditor) {
                        continue; // Skip if no debt or debtor and endCreditor are the same
                    }

                    // Calculate the transaction amount and update the graph accordingly
                    double transactionAmount = Math.min(amount, creditAmount);
                    graph.get(debtor).put(creditor, amount - transactionAmount);
                    graph.get(creditor).put(endCreditor, creditAmount - transactionAmount);
                    // Remove the creditor or endCreditor from the debtor's or creditor's map if the debt is fully settled
                    if (graph.get(debtor).get(creditor) == 0) {
                        graph.get(debtor).remove(creditor);
                    }
                    if (graph.get(creditor).get(endCreditor) == 0) {
                        graph.get(creditor).remove(endCreditor);
                    }

                    // Break the loop if the debt is fully settled
                    if (amount == transactionAmount || creditAmount == transactionAmount) {
                        break;
                    }
                }
            }
        }
    }

    // Public method to simplify debts given a list of Debt objects
    public List<Debt> simplifyDebts(List<Debt> debts) {
        // Calculate net balances for each user
        Map<User, Double>netBalances = calculateNetBalances(debts); // Calculate the net amount each user owes or is owed
        Map<User, Map<User, Double>> graph = buildGraph(netBalances); // Build the graph based on net balances
        reduceGraph(graph); // Simplify the debt relationships in the graph
        return convertGraphToDebts(graph); // Convert the simplified graph back to a list of Debt objects
    }

    // Calculates the net balance for each user based on the list of debts
    private Map<User, Double> calculateNetBalances(List<Debt> debts) {
        Map<User, Double> balances = new HashMap<>(); // Initialize a map to hold the net balances
        for (Debt debt : debts) { // Iterate over each debt
            balances.putIfAbsent(debt.debtor, 0.0); // Initialize the debtor's balance if not already present
            balances.putIfAbsent(debt.debtCollector, 0.0); // Initialize the debt collector's balance if not already present
            // Adjust the debtor's and debt collector's balances
            balances.put(debt.debtor, balances.get(debt.debtor) - debt.amountOwed);
            balances.put(debt.debtCollector, balances.get(debt.debtCollector) + debt.amountOwed);
        }
        return balances; // Return the map of net balances
    }

    // Builds a graph from the net balances, where each user is a node and debts are edges
    private Map<User, Map<User, Double>> buildGraph(Map<User, Double> netBalances) {
        Map<User, Map<User, Double>> graph = new HashMap<>(); // Initialize the graph
        // Iterate over each entry in the net balances map
        for (Map.Entry<User, Double> entry : netBalances.entrySet()) {
            if (entry.getValue() != 0) { // If the user has a net balance (either owes or is owed)
                graph.put(entry.getKey(), new HashMap<>()); // Add the user to the graph with an empty map of debt relationships
            }
        }
        return graph; // Return the constructed graph
    }
}
