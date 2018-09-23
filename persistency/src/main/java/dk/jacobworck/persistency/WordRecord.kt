package dk.jacobworck.persistency

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
class WordRecord {

    @PrimaryKey
    var id: String = ""

    var word: String = ""

}