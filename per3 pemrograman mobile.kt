class StudentCard(
    val nim: String,
    var nama: String,
    val prodi: String
) {
    var totalSks: Int = 0
        private set

    val status: String
        get() = if (totalSks > 0) "Aktif" else "Baru"

    init {
        require(nim.length >= 7) { "NIM tidak valid" }
    }

    fun ambilSks(jumlah: Int) {
        if (jumlah > 0 && totalSks + jumlah <= 24) {
            totalSks += jumlah
        }
    }

    fun ringkasan() =
        "$nim · $nama · $prodi · $totalSks SKS"
}
fun main() {
    // Membuat objek dari class StudentCard
    val mhs = StudentCard("2409020057", "Winda Wardani", "Teknologi Informasi")

    // Menampilkan properti dengan tanda titik
    println("NIM    : ${mhs.nim}")
    println("Nama   : ${mhs.nama}")
    println("Prodi  : ${mhs.prodi}")

    // Mengubah nilai property var
    mhs.nama = "winda"
    println("Nama setelah diubah: ${mhs.nama}")

    // Computed property status (pakai if-else di get())
    println("Status awal: ${mhs.status}")

    // Memanggil method ambilSks()
    mhs.ambilSks(12)
    println("Setelah ambil 12 SKS: ${mhs.totalSks} SKS, status: ${mhs.status}")

    mhs.ambilSks(10)
    println("Setelah ambil 10 SKS: ${mhs.totalSks} SKS")

    // Ditolak karena 22 + 5 = 27, lebih dari 24
    mhs.ambilSks(5)
    println("Setelah ambil 5 SKS: ${mhs.totalSks} SKS")

    // Memanggil method ringkasan()
    println(mhs.ringkasan())
}