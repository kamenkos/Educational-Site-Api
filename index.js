fetch("https://jsonplaceholder.typicode.com/todos")
  .then((result) => result.json())
  .then((data) => {
    var get = document.querySelector("#kartice");
    var dugme = document.querySelector("#flexSwitchCheckDefault");

    function updateDisplay(filterCompleted) {
      var string = "";
      for (var item of data) {
        if (!filterCompleted || item.completed) {
          string += `
                <div class="col col-md-6 col-lg-4 mb-3">
                    <div class="card h-100 border-${boja(item.completed)}">
                        <div class="card-header">
                          User id: ${item.userId}
                        </div>
                        <div class="card-body text-${boja(item.completed)}">
                          Id: ${item.id}
                          <p>Title:${item.title}</p>
                        </div>
                        <div class="card-footer text-body-secondary text-align:center">
                            <a href="#" class="btn btn-${boja(
                              item.completed
                            )}" style="width: 100%;">${
            item.completed ? "Completed" : "Not completed"
          }</a>
                        </div>
                    </div>
                </div>
                `;
        }
      }
      get.innerHTML = string;
    }

    function boja(boja) {
      return boja ? "success" : "danger";
    }

    dugme.addEventListener("change", function () {
      updateDisplay(this.checked);
    });

    // Initial display
    updateDisplay(false);
  });
