package com.makeappssimple.abhimanyu.stackoverflowanswers.android.lazycolumn

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextMeasurer
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.unit.dp
import kotlin.math.ceil

/**
 * https://stackoverflow.com/questions/76534444/how-to-remove-space-between-items-in-lazyverticalgrid-in-jetpack-compose
 */
val words = """
        Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin consequat egestas sodales. Donec tincidunt nulla eu dignissim imperdiet. Aliquam elementum eros ac pharetra vehicula. Praesent sollicitudin fringilla odio, ut condimentum est. Curabitur lobortis scelerisque velit, ut venenatis ante facilisis vitae. Quisque pellentesque sapien non lectus fermentum suscipit. Mauris sed diam vel ex aliquam feugiat. Integer non arcu elementum, condimentum mi vel, efficitur augue. Ut dictum odio urna, sit amet hendrerit purus dignissim at.

        Cras feugiat, elit et mollis sollicitudin, arcu magna mollis velit, quis pretium tortor lorem vitae urna. Aliquam facilisis odio nisi, blandit lobortis purus mollis a. Pellentesque finibus velit augue, ac aliquet dolor ornare sit amet. Curabitur commodo velit nec enim congue tincidunt. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer tempor lorem nec ornare rhoncus. Integer quis blandit dui, et auctor odio. Nunc dictum ac magna convallis maximus. Nulla tempor dui at urna pharetra, non malesuada lacus dignissim. Curabitur tempus dictum orci, id faucibus tellus pulvinar et.

        Nunc sit amet turpis id ante laoreet eleifend. Aenean ut venenatis ipsum. Aliquam erat volutpat. Maecenas lectus ipsum, pellentesque vitae tellus eu, posuere finibus libero. Proin ac mollis mauris. Praesent a auctor odio, nec pretium ante. Etiam sit amet feugiat risus, at semper velit.

        Vivamus tellus nunc, tincidunt quis enim eget, euismod iaculis ante. Vivamus nisl arcu, condimentum at quam vitae, dapibus efficitur ex. Ut eget est lorem. Curabitur euismod, magna nec feugiat dapibus, lacus nibh rutrum augue, eu accumsan nisi lacus non neque. Nullam eleifend erat nisl, at luctus nisi dictum at. Nunc dictum nisi est, eu porta ligula tincidunt nec. Morbi eget maximus purus. Nam auctor blandit est, ut congue odio pharetra eu. Nunc eget arcu viverra, aliquam felis et, laoreet felis. Morbi cursus vehicula leo id tempus.

        Nulla imperdiet ex quis dui volutpat, sit amet mollis tellus laoreet. Cras ut pharetra justo, eget pretium libero. Nullam malesuada arcu ac magna vehicula, in placerat dui eleifend. Phasellus augue eros, ornare ac euismod vitae, tempor eget turpis. Nam interdum metus sit amet nisi pulvinar dignissim. Quisque ligula lorem, luctus non dictum mollis, auctor sed leo. Phasellus est leo, malesuada at dolor nec, sagittis finibus quam. Nunc mattis ornare sem ut cursus. Curabitur pretium porttitor tortor vel tincidunt. Maecenas mattis convallis aliquet. Duis eu felis nec dolor molestie fringilla. Vestibulum sodales elit sed dolor efficitur, non luctus mi commodo. Etiam et nisl vulputate dolor consequat rhoncus at nec magna. Quisque eleifend ligula dignissim justo posuere, nec luctus mi sollicitudin.

        Phasellus vestibulum feugiat rutrum. Sed commodo lobortis odio, a dignissim quam pretium sit amet. Aenean ultricies libero in nisi porta tempus. Integer arcu lacus, accumsan et tempus quis, aliquet vitae elit. Duis euismod dapibus nulla, eget semper tellus feugiat id. Fusce et tempus ligula. Suspendisse ante tortor, cursus ut enim ac, vehicula varius eros. Duis in luctus justo. Nulla vel mi ex. Aenean euismod sem vitae ex malesuada, eu bibendum ex vehicula.

        Proin eget arcu porttitor, fringilla justo at, placerat diam. Sed sed velit justo. Fusce sagittis ligula sed mauris dictum, at pellentesque dolor interdum. Proin scelerisque mi sit amet lacus laoreet, eu vestibulum diam egestas. Quisque ut ultricies risus, nec volutpat orci. Nam et consequat justo. Donec magna eros, porttitor eget gravida sit amet, bibendum fermentum diam. Aliquam fermentum malesuada rutrum.

        Fusce at velit ultricies, placerat metus a, congue felis. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Morbi gravida commodo sapien, ut dictum orci convallis vel. Donec consectetur cursus enim, vitae pellentesque dolor tempus sed. Proin sit amet enim aliquet, molestie libero in, facilisis nunc. Etiam faucibus nec turpis in congue. Maecenas ultricies lacus a magna semper, id tempus turpis aliquam. In dignissim sit amet orci non tempus. Quisque neque nunc, dignissim vitae dui a, tincidunt dictum odio. Integer vitae dui ac elit ullamcorper volutpat.

        Maecenas aliquet leo ut elit pellentesque volutpat. Aliquam tempus ut neque non tempus. Aliquam et nunc magna. Donec vel venenatis enim. Integer cursus quam non diam pharetra suscipit. Sed ornare erat dapibus, consectetur odio non, tristique magna. Duis lorem erat, ornare aliquam vehicula vitae, suscipit ut urna. Etiam dignissim commodo felis, vel pharetra ex malesuada sodales. Etiam ut diam congue, auctor purus at, ultrices leo. Integer mattis nulla neque, nec consectetur orci venenatis non. Curabitur fringilla sit amet lacus sed mollis. Morbi a nisl orci. In vel hendrerit sapien, quis vehicula nibh.

        Interdum et malesuada fames ac ante ipsum primis in faucibus. Phasellus vitae accumsan purus, in lacinia ex. Nunc non est in magna faucibus efficitur quis quis nisi. Duis cursus augue turpis. Sed id augue vehicula, feugiat purus et, mollis mi. Aenean fringilla laoreet nisi sit amet pellentesque. Etiam pellentesque magna condimentum, pellentesque libero porttitor, rhoncus eros. Donec efficitur risus felis, elementum commodo sem maximus a. Aenean sem ipsum, aliquam non varius pretium, bibendum quis est. Aliquam mattis, sapien non rutrum porta, enim ante finibus odio, ut hendrerit mauris quam et nulla. Suspendisse potenti.

        Donec sagittis ipsum vitae tortor dapibus tempus. Sed a velit quis diam elementum scelerisque aliquam lobortis urna. In porttitor ante quam, ut efficitur lorem convallis vitae. Sed porttitor laoreet aliquet. Aliquam vehicula sagittis ante, non tempus risus pellentesque non. Nam quis sem pulvinar, faucibus quam sed, maximus mauris. Sed in justo nec leo condimentum aliquam. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae;

        Aliquam sem risus, congue quis diam non, consequat vehicula dolor. Ut sodales vulputate nisl, ut mattis orci vulputate sed. Fusce fermentum elit ac mi malesuada efficitur eget sit amet ligula. Suspendisse sed metus ut nulla venenatis commodo eget id nisl. Nam auctor venenatis sapien, ut rutrum dolor mattis vitae. Aenean sagittis ante et cursus dictum. Morbi volutpat purus eget mauris iaculis pellentesque. Donec ac sollicitudin purus, a hendrerit mauris.

        Cras accumsan erat vitae maximus pellentesque. Proin eget purus condimentum, malesuada elit id, hendrerit magna. Donec non posuere velit. Nam a dignissim libero. Nulla metus nibh, facilisis eget luctus ac, tristique non arcu. Morbi interdum ac felis non semper. In ac neque vitae nisi ornare ullamcorper ac nec sem. Suspendisse ac risus dui. Aenean accumsan congue purus a maximus. Vestibulum porttitor eu neque vel consequat. Nullam nec mi quam. Integer facilisis commodo nibh id facilisis. Aenean ac porttitor felis. Cras id diam nisl. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec et arcu convallis, posuere ex ac, placerat leo.

        Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Praesent mi dui, tempus in lectus eu, elementum sagittis erat. Fusce id arcu sem. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Integer elit sem, ultrices eu tempus nec, pellentesque at arcu. Nam et justo ante. Donec nibh dolor, laoreet ac dignissim placerat, mattis nec risus. Etiam sed neque lectus.

        Proin non iaculis lacus, blandit dignissim tortor. Interdum et malesuada fames ac ante ipsum primis in faucibus. Donec elementum est metus, a interdum nisl ornare sit amet. Donec in risus quis risus commodo ultricies. Ut quis pharetra tortor, vitae sollicitudin purus. Praesent sit amet dui aliquet, egestas mauris ac, dignissim sem. Nulla varius magna quis ex pretium, eget venenatis velit consequat. Maecenas tortor sapien, laoreet vel augue id, mollis volutpat turpis. Mauris ut eros posuere, gravida orci quis, eleifend erat. Suspendisse varius eu nisl eget maximus. Vivamus finibus sem nec erat dignissim accumsan.

        Duis lobortis ex ante, at pretium eros tincidunt at. Proin efficitur velit in sapien tincidunt, a ornare libero dignissim. Sed ultrices non augue id tincidunt. Nunc iaculis lorem nec nulla auctor, non ultrices dui fringilla. Fusce vitae massa efficitur, eleifend nunc sit amet, euismod neque. Sed scelerisque sem non nulla porta, sed venenatis libero mollis. Sed a dolor id magna condimentum semper vel consectetur nisi. Vestibulum convallis massa quis ex tristique, malesuada ultricies ex commodo. Sed suscipit sem ut lectus semper molestie. Quisque sit amet felis at mi lobortis iaculis. Etiam arcu tellus, sollicitudin non arcu id, bibendum pretium ex. Donec sagittis varius posuere.

        Vestibulum eleifend tempor condimentum. Proin et dui aliquam magna dictum feugiat. Vivamus lacinia id leo id congue. Suspendisse sapien ante, fringilla at tellus nec, dignissim interdum sapien. Maecenas eget enim egestas urna ornare aliquet. In eget nisl odio. Pellentesque egestas orci ac sapien pulvinar consequat. Proin malesuada augue justo, eu venenatis augue finibus vulputate. Quisque augue felis, volutpat in imperdiet in, pellentesque in ante. Etiam sed volutpat massa. Interdum et malesuada fames ac ante ipsum primis in faucibus. Aenean ac mi sit amet lectus maximus sollicitudin at condimentum sem. Vivamus condimentum justo nec dui elementum sollicitudin. Duis et tristique ipsum. Ut aliquam, eros ut porta lacinia, dolor risus egestas arcu, ac dignissim neque eros eu mauris.

        Nullam sodales ipsum lorem, eu tristique augue dapibus aliquet. Phasellus ut viverra odio. Nam ullamcorper, felis ac euismod blandit, velit ante auctor risus, ut hendrerit nibh metus quis tellus. Maecenas magna dui, dignissim et sem quis, rutrum malesuada arcu. Quisque non lorem nulla. Integer euismod quis lorem non fringilla. Integer in arcu risus. Fusce auctor libero et ullamcorper tincidunt. Ut pretium lobortis risus vel blandit. Vivamus sodales iaculis risus sit amet vulputate. Vestibulum id urna nunc. Nullam laoreet ullamcorper quam. Integer accumsan tempus rhoncus. Aenean vehicula elit id mattis facilisis.

        Maecenas sed sem mi. Mauris sit amet felis varius, congue quam quis, pulvinar lectus. Sed vestibulum lectus et varius volutpat. Praesent feugiat neque ut bibendum pulvinar. Vivamus blandit, urna et pharetra porta, ligula dolor aliquet felis, in iaculis dui tortor id dui. Curabitur pretium velit quis hendrerit pellentesque. Quisque et felis nunc. Suspendisse lobortis sapien urna, a consequat tellus elementum malesuada. Aenean fermentum ante lacus, in sollicitudin libero dictum eget. Nunc tempor nibh a pharetra sagittis.

        Nulla ut lectus eget nisl congue placerat ut in lorem. Curabitur nec ipsum vitae justo consectetur blandit. Phasellus facilisis quam ut convallis pharetra. Curabitur id mi sed velit consequat faucibus. Sed aliquet ex vitae tincidunt rutrum. Nullam vestibulum erat felis, a porttitor risus malesuada faucibus. Etiam semper hendrerit purus in vestibulum. Etiam egestas vitae nulla nec cursus. Donec nec tempor elit. Sed rhoncus, libero id convallis maximus, magna lacus placerat massa, quis sagittis tellus massa eu nisl. Cras dolor magna, eleifend eget nisl eget, sodales vestibulum mi. Vivamus et ligula ut turpis porttitor ultricies.

        Nulla pharetra scelerisque lectus ac convallis. Duis id bibendum dolor. Sed mattis ex dolor, sed rhoncus tortor sagittis vel. Nullam ullamcorper sem ipsum, a convallis nisl placerat vitae. Praesent quis tempus eros. Vestibulum ut ante ut sapien volutpat luctus suscipit ac orci. Nullam ante est, dictum molestie ultricies in, facilisis fermentum erat.

        Praesent bibendum consectetur cursus. Morbi auctor mi sem, in rutrum mi elementum eu. In pellentesque libero nec egestas consequat. Praesent porta laoreet gravida. Ut lobortis justo a sapien mattis, ut consectetur massa sagittis. Nulla nec ex in enim cursus vehicula ac a massa. Quisque sit amet semper orci. Nam hendrerit malesuada tristique. Vestibulum vitae scelerisque elit. Mauris tempus sapien eu ligula accumsan feugiat. Aenean iaculis ornare cursus. Nullam neque massa, sollicitudin tincidunt venenatis in, scelerisque sed ipsum. Sed semper tempus malesuada.
    """.trimIndent()
    .split(" ")

@Composable
fun LazyGridUsingLazyColumnDemo(
    items: List<String> = words,
    columns: Int = 2,
) {
    val density = LocalDensity.current
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val textMeasurer: TextMeasurer = rememberTextMeasurer()

    val rows = ceil(items.size.toDouble() / columns).toInt()
    var nthColumnWidth = MutableList(columns) { col ->
        items.filterIndexed { index, _ ->
            index % columns == col
        }.maxOf {
            with(density) {
                textMeasurer.measure(it).size.width.toDp()
            }
        }
    }

    var calculatedColWidthSum = 0.dp
    nthColumnWidth.forEach {
        calculatedColWidthSum += it
    }
    if (calculatedColWidthSum > screenWidth) {
        nthColumnWidth = MutableList(columns) {
            screenWidth / columns
        }
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .navigationBarsPadding(),
    ) {
        items(rows) { row ->
            Row {
                repeat(columns) { col ->
                    val index = row * columns + col
                    if (index < items.size) {
                        Text(
                            text = items[index],
                            modifier = Modifier
                                .then(
                                    if (col < nthColumnWidth.size) {
                                        Modifier
                                            .width(
                                                width = nthColumnWidth[col],
                                            )
                                    } else {
                                        Modifier
                                    }
                                ),
                        )
                    }
                }
            }
        }
    }
}
