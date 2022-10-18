import SwiftUI
import shared

struct ContentView: View {

    var viewmodels = ViewModels()
    var randomDogGridViewModel = viewmodels.getRandomDogGridViewModel()
    @ObservedObject var viewmodel = randomDogGridViewModel.asObservableObject()

	var body: some View {
        let state = viewmodel.randomDog
//         if let success = state as? ResultSuccess {
//             let columns: [GridItem] = Array(
//                 repeating: .init(.flexible()
//             ), count: 3)
//             success.data.forEach {
//                 LazyVGrid(columns: columns){
//                     AsyncImage(url: $0) { image in
//                         image.resizable()
//                     } placeholder: {
//                         ProgressView()
//                     }
//                     .frame(width: 240, height: 126)
//                 }
//             }
//         }

	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
