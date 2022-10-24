import SwiftUI
import shared

struct ContentView: View {
    @ObservedObject var viewmodel = ViewModels().getRandomDogGridViewModel().asObserveableObject()

    var body: some View {
        let state = ResultKs<DataRandomDogResponse>.init(viewmodel.state)
        switch state {
            case .error(let utilResultError):
                Text("ERROR")
            case .loading:
                Text("LOADING")
            case .success(let utilResultSuccess):
                let columns: [GridItem] = Array(
                    repeating: .init(.flexible()
                ), count: 3)
            
            ForEach(utilResultSuccess.data!.message, id:\.self) { url in
                LazyVGrid(columns: columns){
                    if #available(iOS 15.0, *) {
                        AsyncImage(url: URL(string: url)) { image in
                            image.resizable()
                        } placeholder: {
                            ProgressView()
                        }
                        .frame(width: 240, height: 126)
                    } else {
                        Text("VERSION")
                    }
                }
            }
        }
    }
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
