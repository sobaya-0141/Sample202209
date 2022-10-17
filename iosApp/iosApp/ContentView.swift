import SwiftUI
import shared

struct ContentView: View {
    @ObservedObject var viewmodel = ViewModels().getRandomDogGridViewModel().asObserveableObject()
    
	var body: some View {
        let columns: [GridItem] = Array(
            repeating: .init(.flexible()
        ), count: 3)
        
        LazyVGrid(columns: columns){
            AsyncImage(url: imageUrl) { image in
                image.resizable()
            } placeholder: {
                ProgressView()
            }
            .frame(width: 240, height: 126)
        }
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
