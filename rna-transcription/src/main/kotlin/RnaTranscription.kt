fun transcribeToRna(dna: String): String {
    return dna.replace("A", "U").replace("T","A").replace("C", "Q").replace("G","C").replace("Q", "G")
}