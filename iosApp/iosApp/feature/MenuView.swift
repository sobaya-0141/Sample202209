import SwiftUI
import shared

struct MenuView: View {
    var body: some View {
        NavigationView {
            VStack {
                NavigationLink(destination: RandomDogView()) {
                    Text("犬")
                }
                NavigationLink(destination: SearchCatView()) {
                    Text("猫")
                }
            }
        }
    }
}
